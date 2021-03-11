package com.example.demo.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class RouterStartChangePasswordByLoginRequest {

  private String login;
  private String password;

}
