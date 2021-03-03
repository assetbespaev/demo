package com.example.demo.config;

import com.example.demo.wsdl.Axess;
import com.example.demo.wsdl.AxessPortType;
import java.util.Map;
import javax.xml.ws.BindingProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FdmsConfig {

  @Value("${fdms.host}")
  private String host;

  @Value("${fdms.username}")
  private String username;

  @Value("${fdms.password}")
  private String password;

  @Bean
  public AxessPortType axessPortType() {
    Axess axess = new Axess();
    AxessPortType portType = axess.getAxessSOAP11Port();

    BindingProvider provider = (BindingProvider) portType;
    Map<String, Object> requestContext = provider.getRequestContext();
    requestContext.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, host);
    requestContext.put(BindingProvider.USERNAME_PROPERTY, username);
    requestContext.put(BindingProvider.PASSWORD_PROPERTY, password);

    return portType;
  }

}
