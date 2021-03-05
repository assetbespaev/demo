package com.example.demo.wsdl;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class CustomeAdapter extends XmlAdapter {

  @Override
  public Object unmarshal(Object v) throws Exception {
    System.out.println(">>>>>>>> unmarshal");
    return null;
  }

  @Override
  public Object marshal(Object v) throws Exception {
    System.out.println(">>>>>>>> marshal");
    return null;
  }
}
