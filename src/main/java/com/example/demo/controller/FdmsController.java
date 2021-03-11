package com.example.demo.controller;

import com.example.demo.dto.RouterStartChangePasswordByLoginRequest;
import com.example.demo.dto.StartChangePasswordByLogin;
import com.example.demo.service.FdmsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class FdmsController {

  private final FdmsService service;

  @PostMapping("/change-password")
  public ResponseEntity startChangePasswordByLogin(
      @RequestBody RouterStartChangePasswordByLoginRequest request) {
    return ResponseEntity.ok(service.startChangePasswordByLogin(request));
  }

  @GetMapping("/change-password-result")
  public ResponseEntity changePasswordByLoginResult(@RequestParam("taskId") Integer taskId) {
    return ResponseEntity.ok(service.changePasswordByLoginResult(taskId));
  }
}
