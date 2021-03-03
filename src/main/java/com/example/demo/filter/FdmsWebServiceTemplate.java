package com.example.demo.filter;

import org.springframework.ws.client.core.WebServiceTemplate;

public class FdmsWebServiceTemplate extends WebServiceTemplate {

  @Override
  public Object marshalSendAndReceive(Object requestPayload) {

    return super.marshalSendAndReceive(requestPayload);
  }
}
