package com.example.demo.integration.selfcare.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class ChangePasswordByLoginResult {

  @JsonProperty("TaskId")
  private int taskId;

}
