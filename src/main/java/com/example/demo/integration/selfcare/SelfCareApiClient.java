package com.example.demo.integration.selfcare;

import com.example.demo.config.WebClientBuilderWrapper;
import com.example.demo.integration.selfcare.dto.ChangePasswordByLoginResult;
import com.example.demo.integration.selfcare.dto.ChangePasswordByLoginResultResponse;
import com.example.demo.integration.selfcare.dto.StartChangePasswordByLogin;
import com.example.demo.integration.selfcare.dto.StartChangePasswordByLoginResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

@Component
@RequiredArgsConstructor
public class SelfCareApiClient {

  private final SelfCareConfig config;
  private WebClient webClient;

  @Autowired
  private void setWebClient(WebClientBuilderWrapper wrapper) {
    webClient = wrapper.host(config.getHost()).defaultHeaders(this::headers).build();
  }

  private void headers(HttpHeaders headers) {
    headers.setBasicAuth(config.getUsername(), config.getPassword());
  }

  public StartChangePasswordByLoginResponse startChangePasswordByLogin(
      StartChangePasswordByLogin request) {
    return webClient
        .post()
        .uri("/v1/action/StartChangePasswordByLogin")
        .contentType(MediaType.APPLICATION_JSON)
        .body(BodyInserters.fromValue(request))
        .retrieve()
        .bodyToMono(StartChangePasswordByLoginResponse.class)
        .block();
  }

  public ChangePasswordByLoginResultResponse changePasswordByLoginResult(
      ChangePasswordByLoginResult request) {
    return webClient
        .post()
        .uri("/v1/action/ChangePasswordByLoginResult")
        .contentType(MediaType.APPLICATION_JSON)
        .body(BodyInserters.fromValue(request))
        .retrieve()
        .bodyToMono(ChangePasswordByLoginResultResponse.class)
        .block();
  }
}
