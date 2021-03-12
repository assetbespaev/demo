package com.example.demo.integration.selfcare.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;

@Data
public class BaseChangePasswordByLoginResponse {

  @JsonAlias("error")
  private String error;

}
