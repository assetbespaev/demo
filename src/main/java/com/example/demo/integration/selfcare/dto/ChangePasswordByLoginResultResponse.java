
package com.example.demo.integration.selfcare.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Data;
import lombok.ToString;


@Data
@ToString
@JsonInclude(Include.NON_NULL)
public class ChangePasswordByLoginResultResponse extends BaseChangePasswordByLoginResponse {

  @JsonAlias("Result")
  private ChangePasswordByLoginResultStruct result;

}
