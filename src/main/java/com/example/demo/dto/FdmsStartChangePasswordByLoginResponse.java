package com.example.demo.dto;

import lombok.Builder;

@Builder
public class FdmsStartChangePasswordByLoginResponse {

  private int code;
  private String message;
  private Integer taskId;

}
