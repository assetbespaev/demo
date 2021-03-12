
package com.example.demo.integration.selfcare.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;
import lombok.ToString;


@Data
@ToString
public class ChangePasswordByLoginResultResponse {

  @JsonAlias("Result")
  private ChangePasswordByLoginResultStruct result;

}
