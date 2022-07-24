package PracticeJava.xmlParser.StAX;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Iterator;

import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

/**
 * 解析 XML 檔案 / XML 字串的方法 : SAX
 * 
 * TODO: 該方法可讀可寫，補齊使用方法 & 註解
 * 
 * @author oscar51011
 * @date 2022年6月14日
 */
public class Main {

	public static void main(String[] args) throws FactoryConfigurationError, XMLStreamException {
		
		String xml = "<?xml version='1.0' encoding='UTF-8'?><test><req one='one' two='two2'/><resp first='first' second='second2'/></test>";

		InputStream targetStream = new ByteArrayInputStream(xml.getBytes());
		parseXmlByStAX(targetStream);
	}
	
	private static void parseXmlByStAX(InputStream targetStream) throws FactoryConfigurationError, XMLStreamException {
		// (StAX: Streaming API for XML )
		XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
		
		// xmlInputFactory.setProperty(WstxInputProperties.P_MAX_ATTRIBUTE_SIZE, Integer.MAX_VALUE);
		
		XMLEventReader reader = xmlInputFactory.createXMLEventReader(targetStream);
		while (reader.hasNext()) {
		   XMLEvent nextEvent = reader.nextEvent();	
		   // 取 tag
		   if(nextEvent.isStartElement() && nextEvent.asStartElement().getName().getLocalPart().equals("resp")) {
			   
			   StartElement element = nextEvent.asStartElement();
			   
			   System.out.println(element.getName().getLocalPart());
			   
			   @SuppressWarnings("unchecked")
			Iterator<Attribute> attributes = element.getAttributes();
			  
			   // 取 element 內的每個 attribute
			   while(attributes.hasNext()) {
				   
				   Attribute attribute = attributes.next();
				   System.out.println("Key: " + attribute.getName().getLocalPart());				   
				   System.out.println("Value: " + attribute.getValue());
				}		  
		   }
		}
	}
}
