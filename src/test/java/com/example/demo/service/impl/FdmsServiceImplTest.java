package com.example.demo.service.impl;

import com.example.demo.wsdl.ChangePasswordByLoginResult;
import com.example.demo.wsdl.ChangePasswordByLoginResultResponse;
import com.example.demo.wsdl.ChangePasswordByLoginResultStruct;
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
import javax.xml.bind.UnmarshallerHandler;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.util.StreamReaderDelegate;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Document;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLFilter;
import org.xml.sax.XMLReader;
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
  void test() throws JAXBException, ParserConfigurationException, SAXException, IOException {
    // Create the JAXBContext
    JAXBContext jc = JAXBContext.newInstance(ChangePasswordByLoginResultResponse.class);

    // Create the XMLFilter
    XMLFilter filter = new NamespaceFilter();

    // Set the parent XMLReader on the XMLFilter
    SAXParserFactory spf = SAXParserFactory.newInstance();
    SAXParser sp = spf.newSAXParser();
    XMLReader xr = sp.getXMLReader();
    filter.setParent(xr);

    // Set UnmarshallerHandler as ContentHandler on XMLFilter
    Unmarshaller unmarshaller = jc.createUnmarshaller();
    UnmarshallerHandler unmarshallerHandler = unmarshaller
        .getUnmarshallerHandler();
    filter.setContentHandler(unmarshallerHandler);

    // Parse the XML
    InputSource xml = new InputSource("src/forum11465653/response_should_be.xml");
    filter.parse(xml);
    ChangePasswordByLoginResultResponse customer = (ChangePasswordByLoginResultResponse) unmarshallerHandler
        .getResult();

    System.out.println(customer);

  /*  // Marshal the Customer object back to XML
    Marshaller marshaller = jc.createMarshaller();
    marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
    marshaller.marshal(customer, System.out);*/
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


  @Test
  void test_4() throws XMLStreamException, FileNotFoundException, JAXBException {
    XMLInputFactory xif = XMLInputFactory.newFactory();
    XMLStreamReader xsr = xif.createXMLStreamReader(new FileReader("src/forum11465653/response_should_be.xml"));
    xsr.nextTag(); // Advance to Envelope tag

    xsr.nextTag(); // Advance to Body tag
    xsr.nextTag();
    xsr.nextTag();


    JAXBContext jc = JAXBContext.newInstance(ChangePasswordByLoginResultResponse.class);
    Unmarshaller unmarshaller = jc.createUnmarshaller();
    JAXBElement<ChangePasswordByLoginResultResponse> je = unmarshaller.unmarshal(xsr, ChangePasswordByLoginResultResponse.class);

    System.out.println(je.getName());
    System.out.println(je.getValue());
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

  private static final String NAMESPACE = "urn:AxessInterface";

  @Override
  public void endElement(String uri, String localName, String qName)
      throws SAXException {

    super.endElement(NAMESPACE, localName, qName);
  }

  @Override
  public void startElement(String uri, String localName, String qName,
      Attributes atts) throws SAXException {
    System.out.println("uri: " + uri + ", localName: " + localName + ", qName: " + qName);
    if(qName.startsWith("ns1")){
      super.startElement(uri, localName, qName, atts);
      return;
    }
    super.startElement(NAMESPACE, localName, qName, atts);
  }

}