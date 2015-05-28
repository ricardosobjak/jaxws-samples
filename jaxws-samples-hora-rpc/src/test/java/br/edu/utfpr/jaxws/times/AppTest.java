package br.edu.utfpr.jaxws.times;

import static org.junit.Assert.assertTrue;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import org.junit.BeforeClass;
import org.junit.Test;

import br.edu.utfpr.jaxws.hora.service.TimeServer;

public class AppTest {
	private static URL url;
	private static QName qname;
	private static Service service;

	@BeforeClass
	public static void init() throws Exception {
		url = new URL("http://localhost:8888/hora?wsdl");

		// Nome qualificado do serviço:
		// 1º argumento é a URI do serviço
		// 2ª argumento é o nome do serviço publicado no WSDL
		qname = new QName("http://service.hora.jaxws.utfpr.edu.br/", "TimeServerImplService");

		// Criar, efetivamente, uma fábrica para o serviço.
		service = Service.create(url, qname);
	}

	@Test
	public void obterTimes() throws Exception {

		// Extrair o endpoint da interface, o serviço "port".
		TimeServer eif = service.getPort(TimeServer.class);

		System.out.println(eif.getTimeAsString());
		// System.out.println(eif.getTimeAsElapsed());
		assertTrue(true);
	}
}