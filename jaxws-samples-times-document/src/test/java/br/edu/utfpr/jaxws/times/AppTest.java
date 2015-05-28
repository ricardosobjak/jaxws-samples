package br.edu.utfpr.jaxws.times;

import static org.junit.Assert.assertTrue;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import org.junit.BeforeClass;
import org.junit.Test;

import br.edu.utfpr.jaxws.times.service.Times;

public class AppTest {
	private static URL url;
	private static QName qname;

	@BeforeClass
	public static void init() throws Exception {
		url = new URL("http://localhost:8888/times?wsdl");
		
		// Nome qualificado do serviço:
				// 1º argumento é a URI do serviço
				// 2ª argumento é o nome do serviço publicado no WSDL
		qname = new QName("http://service.times.jaxws.utfpr.edu.br/", "TimesImplService");
	}



	@Test
	public void obterTimes() throws Exception {
		// Criar, efetivamente, uma fábrica para o serviço.
		Service service = Service.create(url, qname);

		// Extrair o endpoint da interface, o serviço "port".
		Times eif = service.getPort(Times.class);

		System.out.println(eif.getTimes());
		
		assertTrue(true);
	}
}