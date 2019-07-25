package com.zwo.pls.modules.system;

import org.apache.cxf.binding.soap.SoapHeader;
import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.headers.Header;
import org.apache.cxf.helpers.DOMUtils;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import javax.xml.namespace.QName;
import java.util.List;

public class ClientLoginInterceptor extends AbstractPhaseInterceptor<SoapMessage> {
	private String username;
	private String password;

	public ClientLoginInterceptor(String username, String password) {
		//super(Phase.PREPARE_SEND);
		super(Phase.WRITE);
		this.username = username;
		this.password = password;
	}

	/**
	 * method1
	 * <soap:header>
	  	 <authrity>
		    <username>username</username>
		    <password>password</username>
		  </authrity>
		</soap:header>
	 * @author:spinach
	 * @date:2018年2月8日下午2:54:37
	 * @param soap
	 * @throws Fault
	 */
	/*@Override
	public void handleMessage(SoapMessage soap) throws Fault {
		List<Header> headers = soap.getHeaders();
		Document doc = DOMUtils.createDocument();
		Element auth = doc.createElement("authrity");
		Element username = doc.createElement("username");
		Element password = doc.createElement("password");
		username.setTextContent(this.username);
		password.setTextContent(this.password);
		auth.appendChild(username);
		auth.appendChild(password);
		headers.add(0, new Header(new QName("RequestSOAPHeader"), auth));
	}*/

	/**
	 * method2
	 *  <soap:header>
		    <username>username</username>
		    <password>password</username>
		</soap:header>
	 * @author:spinach
	 * @date:2018年2月8日下午2:55:21
	 * @param soap
	 * @throws Fault
	 */
	@Override
	public void handleMessage(SoapMessage message) throws Fault {
		List<Header> headers = message.getHeaders();
		headers.add(getHeader("username", this.username));
		headers.add(getHeader("password", this.password));
	}

	/**
	 * 拼接头文件
	 * @author:spinach
	 * @date:2018年2月8日下午2:57:48
	 * @param key
	 * @param value
	 * @return
	 */
	private Header getHeader(String key, String value) {
		QName qName = new QName("http://webservice.webxml.com.cn/", key);
		Document document = DOMUtils.createDocument();
		Element element = document.createElementNS("http://webservice.webxml.com.cn/", key);
		element.setTextContent(value);
		SoapHeader header = new SoapHeader(qName, element);
		return (header);
	}

}