package com.example.demo.service.impl;

import com.example.demo.wsdl.ChangePasswordByLoginResult;
import com.example.demo.wsdl.ChangePasswordByLoginResultResponse;
import com.example.demo.wsdl.ChangePasswordByLoginResultStruct;
import com.example.demo.wsdl.ObjectFactory;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.util.StreamReaderDelegate;
import javax.xml.transform.stream.StreamSource;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Document;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.XMLFilterImpl;

class FdmsServiceImplTest {

  @Test
  void test_1() throws FileNotFoundException, XMLStreamException, JAXBException {

    XMLInputFactory xif = XMLInputFactory.newFactory();
    XMLStreamReader xsr = xif.createXMLStreamReader(new FileReader("src/forum11465653/input.xml"));
    xsr.nextTag(); // Advance to Envelope tag
    xsr.nextTag(); // Advance to Body tag
    xsr.nextTag(); // Advance to getNumberResponse tag
    System.out.println(xsr.getNamespaceContext().getNamespaceURI("ns1"));

    JAXBContext jc = JAXBContext.newInstance(ChangePasswordByLoginResultResponse.class);
    Unmarshaller unmarshaller = jc.createUnmarshaller();
    JAXBElement<ChangePasswordByLoginResultResponse> je = unmarshaller
        .unmarshal(xsr, ChangePasswordByLoginResultResponse.class);
    System.out.print("name: ");
    System.out.println(je.getName());
    System.out.print("value: ");
    System.out.println(je.getValue());
  }

  @Test
  void test_2() throws IOException, SOAPException, JAXBException {
    InputStream inStream = new FileInputStream("src/forum11465653/input.xml");
    SOAPMessage message = MessageFactory.newInstance().createMessage(null, inStream);

    Unmarshaller unmarshaller = JAXBContext.newInstance(ChangePasswordByLoginResultResponse.class)
        .createUnmarshaller();

    Document document = message.getSOAPBody().extractContentAsDocument();
    System.out.println(document.getElementsByTagName("ChangePasswordByLoginResultResponse"));
    ChangePasswordByLoginResultResponse response = (ChangePasswordByLoginResultResponse) unmarshaller
        .unmarshal(document);

    System.out.println(response);
  }

  @Test
  void test_3() throws IOException, SOAPException, JAXBException {
    InputStream inStream = new FileInputStream("src/forum11465653/input2.xml");
    SOAPMessage message = MessageFactory.newInstance().createMessage(null, inStream);

    Unmarshaller unmarshaller = JAXBContext.newInstance(ChangePasswordByLoginResult.class)
        .createUnmarshaller();

    Document document = message.getSOAPBody().extractContentAsDocument();
    ChangePasswordByLoginResult response = (ChangePasswordByLoginResult) unmarshaller
        .unmarshal(document);

    System.out.println(response);
  }

  @Test
  void request() throws IOException, SOAPException, JAXBException {
    InputStream inStream = new FileInputStream("src/forum11465653/request.xml");
    SOAPMessage message = MessageFactory.newInstance().createMessage(null, inStream);

    Unmarshaller unmarshaller = JAXBContext.newInstance(ChangePasswordByLoginResult.class)
        .createUnmarshaller();

    Document document = message.getSOAPBody().extractContentAsDocument();
    ChangePasswordByLoginResult request = (ChangePasswordByLoginResult) unmarshaller
        .unmarshal(document);

    System.out.println(request);
  }

  @Test
  void response() throws IOException, SOAPException, JAXBException {
    InputStream inStream = new FileInputStream("src/forum11465653/response.xml");
    SOAPMessage message = MessageFactory.newInstance().createMessage(null, inStream);

    Unmarshaller unmarshaller = JAXBContext.newInstance(ChangePasswordByLoginResultResponse.class)
        .createUnmarshaller();

    Document document = message.getSOAPBody().extractContentAsDocument();
    ChangePasswordByLoginResultResponse response = (ChangePasswordByLoginResultResponse) unmarshaller
        .unmarshal(document);

    System.out.println(response);
  }

  @Test
  void response_should_be() throws IOException, SOAPException, JAXBException {
    InputStream inStream = new FileInputStream("src/forum11465653/response_should_be.xml");
    SOAPMessage message = MessageFactory.newInstance().createMessage(null, inStream);

    Unmarshaller unmarshaller = JAXBContext.newInstance(ChangePasswordByLoginResultResponse.class)
        .createUnmarshaller();

    /*NamespacePrefixMapper mapper = new NamespacePrefixMapper() {
      public String getPreferredPrefix(String namespaceUri, String suggestion,
          boolean requirePrefix) {
        return "";
      }
    };

    unmarshaller.setProperty("com.sun.xml.bind.namespacePrefixMapper", mapper);*/

    Document document = message.getSOAPBody().extractContentAsDocument();
    ChangePasswordByLoginResultResponse response = (ChangePasswordByLoginResultResponse) unmarshaller
        .unmarshal(document);

    System.out.println(response);
  }

  @Test
  void response_should_be_one() throws FileNotFoundException, XMLStreamException, JAXBException {
    XMLInputFactory xif = XMLInputFactory.newFactory();
    XMLStreamReader xsr = xif
        .createXMLStreamReader(new FileReader("src/forum11465653/response_should_be.xml"));
    /*xsr.nextTag(); // Advance to Envelope tag
    xsr.nextTag(); // Advance to Body tag
    xsr.nextTag(); // Advance to getNumberResponse tag
    System.out.println(xsr.getNamespaceContext().getNamespaceURI("ns1"));*/

    JAXBContext jc = JAXBContext.newInstance(ChangePasswordByLoginResultResponse.class);
    Unmarshaller unmarshaller = jc.createUnmarshaller();
    JAXBElement<ChangePasswordByLoginResultResponse> je = unmarshaller
        .unmarshal(xsr, ChangePasswordByLoginResultResponse.class);
    System.out.print("name: ");
    System.out.println(je.getName());
    System.out.print("value: ");
    System.out.println(je.getValue());
  }

  @Test
  void test() throws FileNotFoundException, XMLStreamException, JAXBException {
    JAXBContext jc = JAXBContext.newInstance(ObjectFactory.class);
    XMLInputFactory xif = XMLInputFactory.newFactory();
    xif.setProperty(XMLInputFactory.IS_NAMESPACE_AWARE, false); // this is the magic line
    StreamSource source = new StreamSource(
        new FileInputStream("src/forum11465653/response_should_be.xml"));
    XMLStreamReader xsr = xif.createXMLStreamReader(source);
    Unmarshaller unmarshaller = jc.createUnmarshaller();
    Object response =  unmarshaller
        .unmarshal(xsr);
    System.out.println(response);
  }

  @Test
  void marshaller_response() throws IOException, SOAPException, JAXBException {

    Marshaller marshaller = JAXBContext.newInstance(ChangePasswordByLoginResultResponse.class)
        .createMarshaller();

    ChangePasswordByLoginResultResponse response = new ChangePasswordByLoginResultResponse();
    ChangePasswordByLoginResultStruct struct = new ChangePasswordByLoginResultStruct();
    response.setResult(struct);

    struct.setCode(500);
    struct.setResult("ok");
    struct.setMessage("some message");

    marshaller.marshal(response, new PrintWriter(System.out));
  }
}

class XMLReaderWithoutNamespace extends StreamReaderDelegate {

  public XMLReaderWithoutNamespace(XMLStreamReader reader) {
    super(reader);
  }

  @Override
  public String getAttributeNamespace(int arg0) {
    return "";
  }

  @Override
  public String getNamespaceURI() {
    return "";
  }
}

class NamespaceFilter extends XMLFilterImpl {

  private String usedNamespaceUri;
  private boolean addNamespace;

  //State variable
  private boolean addedNamespace = false;

  public NamespaceFilter(String namespaceUri,
      boolean addNamespace) {
    super();

    if (addNamespace) {
      this.usedNamespaceUri = namespaceUri;
    } else {
      this.usedNamespaceUri = "";
    }
    this.addNamespace = addNamespace;
  }


  @Override
  public void startDocument() throws SAXException {
    super.startDocument();
    if (addNamespace) {
      startControlledPrefixMapping();
    }
  }


  @Override
  public void startElement(String uri, String localName, String qName, Attributes atts)
      throws SAXException {
    super.startElement(this.usedNamespaceUri, localName, qName, atts);
  }

  @Override
  public void endElement(String arg0, String arg1, String arg2)
      throws SAXException {

    super.endElement(this.usedNamespaceUri, arg1, arg2);
  }

  @Override
  public void startPrefixMapping(String prefix, String url)
      throws SAXException {

    if (addNamespace) {
      this.startControlledPrefixMapping();
    } else {
      //Remove the namespace, i.e. don´t call startPrefixMapping for parent!
    }

  }

  private void startControlledPrefixMapping() throws SAXException {

    if (this.addNamespace && !this.addedNamespace) {
      //We should add namespace since it is set and has not yet been done.
      super.startPrefixMapping("", this.usedNamespaceUri);

      //Make sure we dont do it twice
      this.addedNamespace = true;
    }
  }

}