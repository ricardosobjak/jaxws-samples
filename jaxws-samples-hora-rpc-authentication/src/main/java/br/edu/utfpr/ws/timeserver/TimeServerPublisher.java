package br.edu.utfpr.ws.timeserver;
import javax.xml.ws.Endpoint;

/**
 * Esta aplicação publica o web service, cuja SIB � br.edu.utfpr.ws.timeserver.TimeServerImpl. 
 * Por enquanto, o serviçoo está publicado no endereço de rede 127.0.0.1, que é o localhost, 
 * e pelo número da porta 9876. 
 * O caminho publicação é /ts, um nome arbitrário.
 * 
 * A classe Endpoint tem um método sobrecarregado publish. 
 * Nesta versão com dois argumentos, o primeiro argumento 
 * é a URL de publicação passado como uma string e o 
 * segundo argumento é uma instância do serviço SIB, 
 * neste caso é br.edu.utfpr.ws.timeserver.TimeServerImpl.
 * 
 * O aplicativo é executado indefinidamente, aguardando 
 * solicitações de serviço. Uma vez que a aplicação é iniciada, 
 * abra a URL "http://127.0.0.1:9876/ts?wsdl" em um navegador para
 * exibir o contrato de serviço, o documento WSDL. Este é um 
 * teste fácil para determinar se o serviço foi implantado com sucesso. 
 * Se o teste for bem sucedido, o cliente pode então executar o serviço.
*/
public class TimeServerPublisher {
    public static void main(String[ ] args) {
      // 1º argumento é a URL de publicação
      // 2º argumento é a instância da interface SIB 
      Endpoint.publish("http://127.0.0.1:9876/ts", new TimeServerImpl());
    }
}
