package com.example.demo.config;

import io.netty.handler.timeout.ReadTimeoutHandler;
import java.util.concurrent.TimeUnit;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

@Configuration
public class WebClientBuilderConfig {

  @Value("${fdms.rest.host}")
  private String host;

  @Value("${fdms.rest.username}")
  private String username;

  @Value("${fdms.rest.password}")
  private String password;

  @Bean
  public WebClient webClient() {
    HttpClient httpClient = HttpClient.create()
        .doOnConnected(
            conn -> conn.addHandlerLast(new ReadTimeoutHandler(15000L, TimeUnit.MILLISECONDS)))
        /*.option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 5000)
        .responseTimeout(Duration.ofMillis(5000))
        .doOnConnected(conn ->
            conn.addHandlerLast(new ReadTimeoutHandler(5000, TimeUnit.MILLISECONDS))
                .addHandlerLast(new WriteTimeoutHandler(5000, TimeUnit.MILLISECONDS)))*/;

    ReactorClientHttpConnector connector = new ReactorClientHttpConnector(httpClient);

    return WebClient.builder()
        .defaultHeaders(this::headers)
        .baseUrl(host)
        .clientConnector(connector).build();
  }

  private void headers(HttpHeaders headers) {
    headers.setBasicAuth(username, password);
  }

}
