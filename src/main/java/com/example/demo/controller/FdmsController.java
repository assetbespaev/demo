package com.example.demo.controller;

import com.example.demo.service.FdmsService;
import java.rmi.RemoteException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class FdmsController {

  private final FdmsService service;

  @GetMapping("/result")
  public ResponseEntity changePasswordByLoginResult(@RequestParam("taskId") Integer taskId)
      throws RemoteException {
    return ResponseEntity.ok(service.changePasswordByLoginResult(taskId));
  }
}
