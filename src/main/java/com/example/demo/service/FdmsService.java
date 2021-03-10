package com.example.demo.service;

import com.example.demo.dto.RouterStartChangePasswordByLoginResponse;

public interface FdmsService {

  Object startChangePasswordByLogin(RouterStartChangePasswordByLoginResponse request);

  Object changePasswordByLoginResult(int taskId);

}
