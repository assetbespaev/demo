package com.example.demo.config;

import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

@Component
@RequiredArgsConstructor
public class WebClientBuilderWrapper {

  private WebClient.Builder builder = WebClient.builder();

  private Long timeout = 15000L;

  public WebClient build() {

    HttpClient httpClient = HttpClient.create()
        .doOnConnected(
            conn -> conn.addHandlerLast(new ReadTimeoutHandler(timeout, TimeUnit.MILLISECONDS)))
        .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 5000)
        /*.responseTimeout(Duration.ofMillis(5000))
        .doOnConnected(conn ->
            conn.addHandlerLast(new ReadTimeoutHandler(5000, TimeUnit.MILLISECONDS))
                .addHandlerLast(new WriteTimeoutHandler(5000, TimeUnit.MILLISECONDS)))*/;

    ReactorClientHttpConnector connector = new ReactorClientHttpConnector(httpClient);

    return builder
        .clientConnector(connector)
        .build();
  }

  public WebClientBuilderWrapper host(String host) {
    this.builder.baseUrl(host);
    return this;
  }

  public WebClientBuilderWrapper defaultHeaders(Consumer<HttpHeaders> headersConsumer) {
    builder.defaultHeaders(headersConsumer);
    return this;
  }

  public WebClientBuilderWrapper timeout(Long timeoutMillis) {
    this.timeout = timeoutMillis;
    return this;
  }

}
