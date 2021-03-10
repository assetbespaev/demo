package com.example.demo.service.impl;

import com.example.demo.dto.FdmsChangePasswordByLoginResponse;
import com.example.demo.dto.FdmsChangePasswordByLoginResponse.FdmsChangePasswordByLoginResponseBuilder;
import com.example.demo.service.FdmsService;
import com.example.demo.wsdl.AxessPortType;
import com.example.demo.wsdl.ChangePasswordByLoginResultStruct;
import com.example.demo.wsdl.ChangePasswordByLoginResultStructCode;
import java.rmi.RemoteException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FdmsServiceImpl implements FdmsService {

  private final AxessPortType axessPortType;

  @Override
  public FdmsChangePasswordByLoginResponse changePasswordByLoginResult(int taskId)
      throws RemoteException {

    ChangePasswordByLoginResultStruct struct = axessPortType
        .changePasswordByLoginResult(taskId);
    System.out.println(struct);
    ChangePasswordByLoginResultStructCode code = struct.getCode();
    FdmsChangePasswordByLoginResponseBuilder result = FdmsChangePasswordByLoginResponse.builder()
        .message(struct.getMessage())
        .result(struct.getResult());

    if (code != null) {
      result.code(code.getValue());
    }

    return result.build();
  }
}

