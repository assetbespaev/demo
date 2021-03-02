package com.example.demo.config;

import com.example.demo.wsdl.Axess;
import com.example.demo.wsdl.AxessLocator;
import com.example.demo.wsdl.AxessPortType;
import javax.xml.rpc.ServiceException;
import javax.xml.rpc.Stub;
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
  public AxessPortType axessPortType() throws ServiceException {
    Axess axess = new AxessLocator();
    AxessPortType portType = axess.getaxessSOAP11Port();

    Stub stub = (Stub) portType;
    stub._setProperty(Stub.ENDPOINT_ADDRESS_PROPERTY, host);
    stub._setProperty(Stub.USERNAME_PROPERTY, username);
    stub._setProperty(Stub.PASSWORD_PROPERTY, password);
    return portType;
  }

}
