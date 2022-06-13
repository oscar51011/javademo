package PracticeJava.xmlParser.JAXB;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement(name = "test")
public class Test {
	
	@XmlElement
	private Req req;
	
	@XmlElement
	private Resp resp;
	
	@XmlTransient
	public Req getReq() {
		return req;
	}

	public void setReq(Req req) {
		this.req = req;
	}

	@XmlTransient
	public Resp getResp() {
		return resp;
	}

	public void setResp(Resp resp) {
		this.resp = resp;
	}
	
	

}
