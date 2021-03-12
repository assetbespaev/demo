package com.example.demo.dto;

import javax.validation.constraints.NotBlank;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ChangePasswordRequest {

  @NotBlank
  private String login;

  @NotBlank
  private String password;

}
