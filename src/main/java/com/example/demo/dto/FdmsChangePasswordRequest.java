package com.example.demo.dto;


import javax.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class FdmsChangePasswordRequest {

  @NotBlank
  private String login;

  @NotBlank
  private String password;

}
