package br.edu.utfpr.jaxws.hora.service;
import java.util.Date;
import javax.jws.WebService;

/**
 *  A propriedade endpointInterface da @WebService liga o SIB (esta classe) 
 *  para o SEI (br.edu.utfpr.jaxws.hora.TimeServer).
 *  Note-se que as implementações de métodos não são anotadas como @WebMethods.
*/

@WebService(endpointInterface = "br.edu.utfpr.jaxws.hora.service.TimeServer")
public class TimeServerImpl implements TimeServer {
	
    public String getTimeAsString() {
    	return new Date().toString(); 
    }
    
    public long getTimeAsElapsed() { 
    	return new Date().getTime(); 
    }
}
