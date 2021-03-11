package com.example.demo.service;

import com.example.demo.dto.ChangePasswordByLoginResultResponse;
import com.example.demo.dto.RouterStartChangePasswordByLoginRequest;
import com.example.demo.dto.RouterStartChangePasswordByLoginResponse;
import com.example.demo.dto.StartChangePasswordByLogin;
import com.example.demo.dto.StartChangePasswordByLoginResponse;

public interface FdmsService {

  StartChangePasswordByLoginResponse startChangePasswordByLogin(
      RouterStartChangePasswordByLoginRequest request);

  ChangePasswordByLoginResultResponse changePasswordByLoginResult(int taskId);

}
