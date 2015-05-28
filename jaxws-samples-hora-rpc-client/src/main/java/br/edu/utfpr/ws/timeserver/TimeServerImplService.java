package br.edu.utfpr.ws.timeserver;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;

@WebServiceClient(name = "TimeServerImplService", 
		targetNamespace = "http://timeserver.ws.utfpr.edu.br/", 
		wsdlLocation = "http://localhost:9876/ts?wsdl")
public class TimeServerImplService extends Service {

	private final static URL TIMESERVERIMPLSERVICE_WSDL_LOCATION;
	private final static WebServiceException TIMESERVERIMPLSERVICE_EXCEPTION;
	private final static QName TIMESERVERIMPLSERVICE_QNAME = new QName(
			"http://timeserver.ws.utfpr.edu.br/", "TimeServerImplService");

	static {
		URL url = null;
		WebServiceException e = null;
		try {
			url = new URL("http://localhost:9876/ts?wsdl");
		} catch (MalformedURLException ex) {
			e = new WebServiceException(ex);
		}
		TIMESERVERIMPLSERVICE_WSDL_LOCATION = url;
		TIMESERVERIMPLSERVICE_EXCEPTION = e;
	}

	public TimeServerImplService() {
		super(__getWsdlLocation(), TIMESERVERIMPLSERVICE_QNAME);
	}

	public TimeServerImplService(WebServiceFeature... features) {
		super(__getWsdlLocation(), TIMESERVERIMPLSERVICE_QNAME, features);
	}

	public TimeServerImplService(URL wsdlLocation) {
		super(wsdlLocation, TIMESERVERIMPLSERVICE_QNAME);
	}

	public TimeServerImplService(URL wsdlLocation,
			WebServiceFeature... features) {
		super(wsdlLocation, TIMESERVERIMPLSERVICE_QNAME, features);
	}

	public TimeServerImplService(URL wsdlLocation, QName serviceName) {
		super(wsdlLocation, serviceName);
	}

	public TimeServerImplService(URL wsdlLocation, QName serviceName,
			WebServiceFeature... features) {
		super(wsdlLocation, serviceName, features);
	}

	@WebEndpoint(name = "TimeServerImplPort")
	public TimeServer getTimeServerImplPort() {
		return super.getPort(new QName("http://timeserver.ws.utfpr.edu.br/",
				"TimeServerImplPort"), TimeServer.class);
	}

	@WebEndpoint(name = "TimeServerImplPort")
	public TimeServer getTimeServerImplPort(WebServiceFeature... features) {
		return super.getPort(new QName("http://timeserver.ws.utfpr.edu.br/",
				"TimeServerImplPort"), TimeServer.class, features);
	}

	private static URL __getWsdlLocation() {
		if (TIMESERVERIMPLSERVICE_EXCEPTION != null) {
			throw TIMESERVERIMPLSERVICE_EXCEPTION;
		}
		return TIMESERVERIMPLSERVICE_WSDL_LOCATION;
	}
}
