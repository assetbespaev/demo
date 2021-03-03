package com.example.demo.service.impl;

import com.example.demo.dto.FdmsChangePasswordByLoginResponse;
import com.example.demo.service.FdmsService;
import com.example.demo.wsdl.AxessPortType;
import com.example.demo.wsdl.ChangePasswordByLoginResultStruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FdmsServiceImpl implements FdmsService {

  private final AxessPortType axessPortType;

  @Override
  public FdmsChangePasswordByLoginResponse changePasswordByLoginResult(int taskId) {

    ChangePasswordByLoginResultStruct struct = axessPortType
        .changePasswordByLoginResult(taskId);

    return FdmsChangePasswordByLoginResponse.builder()
        .code(struct.getCode())
        .message(struct.getMessage())
        .result(struct.getResult())
        .build();
  }
}

