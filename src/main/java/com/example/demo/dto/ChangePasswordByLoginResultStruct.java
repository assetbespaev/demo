
package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ChangePasswordByLoginResultStruct {

  @JsonAlias("Code")
  private int code;

  @JsonAlias("Message")
  private String message;

  @JsonAlias("Result")
  private String result;

}
