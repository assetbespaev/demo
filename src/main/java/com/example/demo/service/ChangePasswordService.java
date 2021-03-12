package com.example.demo.service;

import com.example.demo.dto.ChangePasswordRequest;
import com.example.demo.integration.selfcare.dto.ChangePasswordByLoginResultResponse;
import com.example.demo.integration.selfcare.dto.StartChangePasswordByLoginResponse;

public interface ChangePasswordService {

  StartChangePasswordByLoginResponse changePassword(
      ChangePasswordRequest request);

  ChangePasswordByLoginResultResponse changePasswordResult(int taskId);

}
