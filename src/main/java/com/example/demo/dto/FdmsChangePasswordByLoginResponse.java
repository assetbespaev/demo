package com.example.demo.dto;

import lombok.Builder;

@Builder
public class FdmsChangePasswordByLoginResponse {

  private int code;
  private String message;
  private String result;

}
