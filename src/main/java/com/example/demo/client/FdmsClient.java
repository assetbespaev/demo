package com.example.demo.client;

import com.example.demo.wsdl.ChangePasswordByLoginResult;
import com.example.demo.wsdl.ChangePasswordByLoginResultResponse;
import com.example.demo.wsdl.ObjectFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class FdmsClient extends WebServiceGatewaySupport {

  public ChangePasswordByLoginResultResponse changePasswordByLoginResult(int taskId) {
    ObjectFactory factory = new ObjectFactory();
    ChangePasswordByLoginResult request = factory.createChangePasswordByLoginResult();
    request.setTaskId(taskId);

    ChangePasswordByLoginResultResponse response = (ChangePasswordByLoginResultResponse) getWebServiceTemplate().marshalSendAndReceive(
        request, new SoapActionCallback("http://localhost:8080/soapws/getArticleByIdRequest"));
    return response;
  }

}
