package com.example.demo.service.impl;

import com.example.demo.dto.RouterStartChangePasswordByLoginResponse;
import com.example.demo.service.FdmsService;
import com.example.demo.wsdl.ChangePasswordByLoginResult;
import com.example.demo.wsdl.ObjectFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;

@Service
@RequiredArgsConstructor
public class FdmsServiceImpl implements FdmsService {

  private final WebServiceTemplate template;

  @Override
  public Object startChangePasswordByLogin(RouterStartChangePasswordByLoginResponse request) {
    return null;
  }

  @Override
  public Object changePasswordByLoginResult(int taskId) {
    ObjectFactory factory = new ObjectFactory();
    ChangePasswordByLoginResult request = factory.createChangePasswordByLoginResult();
    request.setTaskId(taskId);

    return template.marshalSendAndReceive(request);
  }
}

