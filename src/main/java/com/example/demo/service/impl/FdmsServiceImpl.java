package com.example.demo.service.impl;

import com.example.demo.dto.ChangePasswordByLoginResult;
import com.example.demo.dto.ChangePasswordByLoginResultResponse;
import com.example.demo.dto.RouterStartChangePasswordByLoginRequest;
import com.example.demo.dto.StartChangePasswordByLogin;
import com.example.demo.dto.StartChangePasswordByLoginResponse;
import com.example.demo.request.FdmsRequest;
import com.example.demo.service.FdmsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FdmsServiceImpl implements FdmsService {

  private final FdmsRequest fdmsRequest;

  @Override
  public StartChangePasswordByLoginResponse startChangePasswordByLogin(
      RouterStartChangePasswordByLoginRequest request) {
    return fdmsRequest.startChangePasswordByLogin(
        StartChangePasswordByLogin.builder()
            .login(request.getLogin())
            .password(request.getPassword())
            .build()
    );
  }

  @Override
  public ChangePasswordByLoginResultResponse changePasswordByLoginResult(int taskId) {
    return fdmsRequest
        .changePasswordByLoginResult(
            ChangePasswordByLoginResult.builder()
                .taskId(taskId)
                .build()
        );
  }
}

