package PracticeJava.xmlParser.JAXB;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

/**
 * 解析 XML 檔案 / XML 字串的方法 : JAXB
 * 
 * @author oscar51011
 * @date 2022年6月14日
 */
public class Main {

	public static void main(String[] args) throws XMLStreamException, ParserConfigurationException, SAXException, IOException, JAXBException {
		
		

		
		String xml = "<?xml version='1.0' encoding='MS950'?><test><req one='one' two='two2'/><resp first='first' second='second2'/></test>";
	
		InputStream targetStream = new ByteArrayInputStream(xml.getBytes());
		InputSource source = new InputSource(targetStream);


		// 2. 使用 StAX
		// parseXmlByStAX(targetStream);
		// 3. 使用 JXAB
		
		parseXmlByJAXB(targetStream);
	}

	private static void parseXmlByJAXB(InputStream targetStream) throws JAXBException {
		JAXBContext context = JAXBContext.newInstance(Test.class);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		Test test = (Test) unmarshaller.unmarshal(targetStream);
		System.out.println(test.getReq().getOne());
		System.out.println(test.getReq().getTwo());
		System.out.println(test.getResp().getFirst());
		System.out.println(test.getResp().getSecond());
	}
}
