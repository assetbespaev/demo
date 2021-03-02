package com.example.demo.config;

import com.example.demo.wsdl.Axess;
import com.example.demo.wsdl.AxessLocator;
import com.example.demo.wsdl.AxessPortType;
import javax.xml.rpc.ServiceException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FdmsConfig {

  @Bean
  public AxessPortType axessPortType() throws ServiceException {
    Axess axess = new AxessLocator();
    AxessPortType portType = axess.getaxessSOAP11Port();

    return portType;
  }

}
