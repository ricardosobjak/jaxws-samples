package br.edu.utfpr.ws.cliente;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import br.edu.utfpr.ws.timeserver.TimeServer;

import java.net.URL;

public class TimeClientSSL {

	static {
		// for localhost testing only
		javax.net.ssl.HttpsURLConnection
				.setDefaultHostnameVerifier(new javax.net.ssl.HostnameVerifier() {
					public boolean verify(String hostname,
							javax.net.ssl.SSLSession sslSession) {
						if (hostname.equals("localhost")) {
							return true;
						}
						return false;
					}
				});
	}

	public static void main(String args[]) throws Exception {
		URL url = new URL("https://localhost:8443/timeserver/ts?wsdl");

		// Nome qualificado do serviço:
		// 1º argumento é a URI do serviço
		// 2º argumento é o nome do serviço publicado no WSDL
		QName qname = new QName("http://timeserver.ws.utfpr.edu.br/",
				"TempoService");

		// Criar, efetivamente, uma fábrica para o serviço.
		Service service = Service.create(url, qname);

		// Extrair o endpoint da interface, o serviço "port".
		TimeServer eif = service.getPort(TimeServer.class);

		System.out.println(eif.getTimeAsString());
		System.out.println(eif.getTimeAsElapsed());
		System.out.println(eif.getNameOfMonth(5));
	}
}
