package com.example.demo.service.impl;

import com.example.demo.dto.ChangePasswordRequest;
import com.example.demo.integration.selfcare.SelfCareApiClient;
import com.example.demo.integration.selfcare.dto.ChangePasswordByLoginResult;
import com.example.demo.integration.selfcare.dto.ChangePasswordByLoginResultResponse;
import com.example.demo.integration.selfcare.dto.StartChangePasswordByLogin;
import com.example.demo.integration.selfcare.dto.StartChangePasswordByLoginResponse;
import com.example.demo.service.ChangePasswordService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChangePasswordServiceImpl implements ChangePasswordService {

  private final SelfCareApiClient client;

  @Override
  public StartChangePasswordByLoginResponse changePassword(ChangePasswordRequest request) {
    return client
        .startChangePasswordByLogin(
            StartChangePasswordByLogin.builder()
                .login(request.getLogin())
                .password(request.getPassword())
                .build()
        );
  }

  @Override
  public ChangePasswordByLoginResultResponse changePasswordResult(int taskId) {
    return client
        .changePasswordByLoginResult(
            ChangePasswordByLoginResult.builder()
                .taskId(taskId)
                .build()
        );
  }
}

