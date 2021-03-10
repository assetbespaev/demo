package com.example.demo.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class FdmsChangePasswordByLoginResponse {

  private int code;
  private String message;
  private String result;

}
