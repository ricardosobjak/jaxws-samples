package br.edu.utfpr.jaxws.times;

import br.edu.utfpr.ws.timeserver.TimeServer;
import br.edu.utfpr.ws.timeserver.TimeServerImplService;

public class Cliente {
	public static void main(String[] args) {
		TimeServerImplService servico = new TimeServerImplService();
		TimeServer timeServer = servico.getTimeServerImplPort();
		
		System.out.println(timeServer.getTimeAsElapsed());
		System.out.println(timeServer.getTimeAsString());
	}
}