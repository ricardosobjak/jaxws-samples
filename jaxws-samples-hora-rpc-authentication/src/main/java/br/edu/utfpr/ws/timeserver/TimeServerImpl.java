package br.edu.utfpr.ws.timeserver;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.jws.WebService;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

/**
 *  A propriedade endpointInterface da @WebService liga o SIB (esta classe) 
 *  para o SEI (br.edu.utfpr.ws.timeserver.TimeServer).
 *  Note-se que as implementações de métodos não são anotadas como @WebMethods.
*/

@WebService(endpointInterface = "br.edu.utfpr.ws.timeserver.TimeServer")
public class TimeServerImpl implements TimeServer {
	@Resource
    WebServiceContext wsCtx;

    public String getTimeAsString() {
    	if (autentica())
    		return new Date().toString();
    	else
    		return "Usu�rio/Senha n�o conferem";
    }
    public long getTimeAsElapsed() { 
    	return new Date().getTime(); 
    }
    
	private boolean autentica() {
		
		MessageContext mctx = wsCtx.getMessageContext();
		
		//get detail from request headers
        Map http_headers = (Map) mctx.get(MessageContext.HTTP_REQUEST_HEADERS);
        List userList = (List) http_headers.get("Username");
        List passList = (List) http_headers.get("Password");

        String username = "";
        String password = "";
        
        if(userList != null){
        	//get username
        	username = userList.get(0).toString();
        }
        	
        if(passList != null){
        	//get password
        	password = passList.get(0).toString();
        }
        	
        //Should validate username and password with database
        if (username.equals("utfpr") && password.equals("123456"))
        	return true;
        else
        	return false;
	}
}
