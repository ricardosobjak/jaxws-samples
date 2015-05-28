package br.edu.utfpr.ws.cliente;

import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Service;
import javax.xml.ws.handler.MessageContext;

import br.edu.utfpr.ws.timeserver.TimeServer;

import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class TimeClient {
	private static final String WS_URL = "http://localhost:9876/ts?wsdl";
	
    public static void main(String args[ ]) throws Exception {
        URL url = new URL(WS_URL);

        // Nome qualificado do serviço:
        //   1º argumento é a URI do serviço
        //   2º argumento é o nome do serviço publicado no WSDL
        QName qname = new QName("http://timeserver.ws.utfpr.edu.br/", "TimeServerImplService");

        // Criar, efetivamente, uma fábrica para o serviço.
        Service service = Service.create(url, qname);

        // Extrair o endpoint da interface, o serviço "port".
        TimeServer eif = service.getPort(TimeServer.class);
        
        /*******************UserName & Password ******************************/
        Map<String, Object> req_ctx = ((BindingProvider)eif).getRequestContext();
        req_ctx.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, WS_URL);

        Map<String, List<String>> headers = new HashMap<String, List<String>>();
        headers.put("Username", Collections.singletonList("utfpr"));
        headers.put("Password", Collections.singletonList("123456"));
        req_ctx.put(MessageContext.HTTP_REQUEST_HEADERS, headers);
        /**********************************************************************/
     
        
        System.out.println(eif.getTimeAsString());
        System.out.println(eif.getTimeAsElapsed());
   }
}
