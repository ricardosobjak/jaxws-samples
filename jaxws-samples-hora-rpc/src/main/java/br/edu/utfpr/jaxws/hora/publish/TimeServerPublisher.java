package br.edu.utfpr.jaxws.hora.publish;
import javax.xml.ws.Endpoint;

import br.edu.utfpr.jaxws.hora.service.TimeServerImpl;

/**
 * Esta aplica��o publica o web service, cuja SIB � br.edu.utfpr.ws.timeserver.TimeServerImpl. 
 * Por enquanto, o servi�o est� publicado no endere�o de rede 127.0.0.1, que � o localhost, 
 * e pelo n�mero da porta 9876. 
 * O caminho publica��o � /ts, um nome arbitr�rio.
 * 
 * A classe Endpoint tem um m�todo sobrecarregado publish. 
 * Nesta vers�o com dois argumentos, o primeiro argumento 
 * � a URL de publica��o passado como uma string e o 
 * segundo argumento � uma inst�ncia do servi�o SIB, 
 * neste caso � br.edu.utfpr.ws.timeserver.TimeServerImpl.
 * 
 * O aplicativo � executado indefinidamente, aguardando 
 * solicita��es de servi�o. Uma vez que a aplica��o � iniciada, 
 * abra a URL "http://127.0.0.1:9876/ts?wsdl" em um navegador para
 * exibir o contrato de servi�o, o documento WSDL. Este � um 
 * teste f�cil para determinar se o servi�o foi implantado com sucesso. 
 * Se o teste for bem sucedido, o cliente pode ent�o executar o servi�o.
*/
public class TimeServerPublisher {
    public static void main(String[ ] args) {
      // 1º argumento é a URL de publicação
      // 2º argumento é a instância da interface SIB 
      Endpoint.publish("http://localhost:8888/hora", new TimeServerImpl());
      System.out.println("WebService HoraServer está respondendo na porta 8888");
    }
}
