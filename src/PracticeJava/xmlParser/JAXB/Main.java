package PracticeJava.xmlParser.JAXB;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;

import org.xml.sax.SAXException;

/**
 * 解析 XML 字串的方法 : JAXB
 * 
 * @author oscar51011
 * @date 2022年6月14日
 */
public class Main {

	public static void main(String[] args) throws XMLStreamException, ParserConfigurationException, SAXException, IOException, JAXBException {
		
		System.out.println("=== transfer XML String to Bean Demo ===");
		
		// 從 XML String 轉成 Bean
		String xmlString = "<?xml version='1.0' encoding='UTF-8' standalone=\"yes\"?><test><req one='one' two='two2'/><resp first='first' second='second2'/></test>";	
		Test test = parseXmltoBeanByJAXB(xmlString, Test.class);
		System.out.println(test.getReq().getOne());
		System.out.println(test.getReq().getTwo());
		System.out.println(test.getResp().getFirst());
		System.out.println(test.getResp().getSecond());
		
		System.out.println("=== transfer Bean to XML String Demo ===");
		
		// 從 Bean 轉成 XML String
		Test test2 = new Test();
		Req req = new Req();
		req.setOne("o1");
		req.setTwo("t2");
		Resp resp = new Resp();
		resp.setFirst("f1");
		resp.setSecond("s1");
		test2.setReq(req);
		test2.setResp(resp);
		
		String resultXml = parseBeantoXmlStringByJAXB(test2);
		System.out.println(resultXml);
		
	}


	/**
	 * 從 XML String 轉成 Bean
	 * @param <T>
	 * @param xmlString
	 * @param clazz
	 * @return
	 * @throws JAXBException
	 */
	@SuppressWarnings("unchecked")
	private static <T> T parseXmltoBeanByJAXB(String xmlString, Class<T> clazz) throws JAXBException {
		InputStream targetStream = new ByteArrayInputStream(xmlString.getBytes());		
		JAXBContext context = JAXBContext.newInstance(clazz);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		return (T) unmarshaller.unmarshal(targetStream);
	}
	
	/**
	 * 從 Bean 轉成 XML String
	 * @param <T>
	 * @param object
	 * @return
	 * @throws JAXBException
	 */
	private static <T> String parseBeantoXmlStringByJAXB(T object) throws JAXBException {
		JAXBContext context = JAXBContext.newInstance(object.getClass());
		Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		StringWriter sw = new StringWriter();
		marshaller.marshal(object, sw);
		return sw.toString();
	}
}
