package com.example.demo.config;

import com.example.demo.wsdl.ObjectFactory;
import java.util.HashMap;
import java.util.Map;
import javax.xml.bind.Marshaller;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.transport.http.HttpComponentsMessageSender;

@Configuration
public class FdmsConfig {

  @Value("${fdms.host}")
  private String host;

  @Value("${fdms.username}")
  private String username;

  @Value("${fdms.password}")
  private String password;

  @Bean
  public Jaxb2Marshaller marshaller() {
    Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller();
//    jaxb2Marshaller.setContextPath("com.example.demo.wsdl");
    jaxb2Marshaller.setContextPath(ObjectFactory.class.getPackage().getName());
    Map<String, Object> prop = new HashMap<>();
    prop.put(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
    jaxb2Marshaller.setMarshallerProperties(prop);
    jaxb2Marshaller.setCheckForXmlRootElement(false);
    return jaxb2Marshaller;
  }

  @Bean
  public WebServiceTemplate webServiceTemplate() {
    WebServiceTemplate webServiceTemplate = new WebServiceTemplate();
    webServiceTemplate.setMarshaller(marshaller());
    webServiceTemplate.setUnmarshaller(marshaller());
    webServiceTemplate.setDefaultUri(host);
    // set a HttpComponentsMessageSender which provides support for basic authentication
    webServiceTemplate.setMessageSender(httpComponentsMessageSender());

    return webServiceTemplate;
  }

  @Bean
  public HttpComponentsMessageSender httpComponentsMessageSender() {
    HttpComponentsMessageSender httpComponentsMessageSender = new HttpComponentsMessageSender();
    // set the basic authorization credentials
    httpComponentsMessageSender.setCredentials(usernamePasswordCredentials());

    return httpComponentsMessageSender;
  }

  @Bean
  public UsernamePasswordCredentials usernamePasswordCredentials() {
    // pass the user name and password to be used
    return new UsernamePasswordCredentials(username, password);
  }
}
