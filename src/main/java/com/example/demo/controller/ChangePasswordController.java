package com.example.demo.controller;

import com.example.demo.dto.ChangePasswordRequest;
import com.example.demo.service.ChangePasswordService;
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
@RequestMapping("/api/v1/change-password")
public class ChangePasswordController {

  private final ChangePasswordService changePasswordService;

  @PostMapping
  public ResponseEntity changePassword(
      @RequestBody ChangePasswordRequest request) {
    return ResponseEntity.ok(changePasswordService.changePassword(request));
  }

  @GetMapping("/result")
  public ResponseEntity changePasswordResult(@RequestParam("taskId") int taskId) {
    return ResponseEntity.ok(changePasswordService.changePasswordResult(taskId));
  }
}
