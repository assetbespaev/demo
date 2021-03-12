package com.example.demo.integration.selfcare;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ToString
@Data
@Configuration
@ConfigurationProperties("integration.self-care.rest")
public class SelfCareConfig {

  private String host;
  private String username;
  private String password;

}
