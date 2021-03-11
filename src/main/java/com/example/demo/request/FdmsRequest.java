package com.example.demo.request;

import com.example.demo.dto.ChangePasswordByLoginResult;
import com.example.demo.dto.ChangePasswordByLoginResultResponse;
import com.example.demo.dto.StartChangePasswordByLogin;
import com.example.demo.dto.StartChangePasswordByLoginResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

@Component
@RequiredArgsConstructor
public class FdmsRequest {

  private final WebClient webClient;

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
