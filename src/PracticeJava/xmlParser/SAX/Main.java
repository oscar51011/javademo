package PracticeJava.xmlParser.SAX;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

/**
 * 解析 XML 檔案 / XML 字串的方法 : SAX
 * 
 * TODO: 該方法只能讀，補齊使用方法 & 註解
 * 
 * @author oscar51011
 * @date 2022年6月14日
 */
public class Main {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		
		String xml = "<?xml version='1.0' encoding='MS950'?><test><req one='one' two='two2'/><resp first='first' second='second2'/></test>";

		InputStream targetStream = new ByteArrayInputStream(xml.getBytes());
		InputSource source = new InputSource(targetStream);
		
		parseXmlBySAX(source);
	}
	
	private static void parseXmlBySAX(InputSource source)
			throws ParserConfigurationException, SAXException, IOException {
		// (SAX: Simple API for XML )
		SAXParser sax = SAXParserFactory.newInstance().newSAXParser();
		XMLReader reader = sax.getXMLReader();
		reader.setContentHandler(new DefaultHandler() {

			@Override
			public void startElement(String uri, String localName, String qName, Attributes attributes)
					throws SAXException {
							
				System.out.println("一個元素開始,名字爲:"+qName);

				System.out.println(attributes.getLength());
				
				if(attributes.getLength() > 0) {				
					System.out.println( attributes.getQName(0) );
					System.out.println( attributes.getValue(0) );
					System.out.println( attributes.getQName(1) );
					System.out.println( attributes.getValue(1) );
				}
								
				//super.startElement(uri, localName, qName, attributes);
			}
			
		});
		
		reader.parse(source);
	}
}
