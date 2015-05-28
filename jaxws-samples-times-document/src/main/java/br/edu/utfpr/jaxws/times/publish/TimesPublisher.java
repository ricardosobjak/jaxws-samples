package br.edu.utfpr.jaxws.times.publish;
import javax.xml.ws.Endpoint;

import br.edu.utfpr.jaxws.times.service.TimesImpl;

public class TimesPublisher {
	public static void main(String[] args) {
		int port = 8888;
		String url = "http://localhost:" + port + "/times";
		System.out.println("Publicando Times na porta " + port);
		Endpoint.publish(url, new TimesImpl());
	}
} 
