package br.edu.utfpr.ws.timeserver;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.Action;

@WebService(name = "TimeServer", targetNamespace = "http://timeserver.ws.utfpr.edu.br/")
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface TimeServer {
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://timeserver.ws.utfpr.edu.br/TimeServer/getTimeAsStringRequest", 
    		output = "http://timeserver.ws.utfpr.edu.br/TimeServer/getTimeAsStringResponse")
    public String getTimeAsString();

    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://timeserver.ws.utfpr.edu.br/TimeServer/getTimeAsElapsedRequest", 
    		output = "http://timeserver.ws.utfpr.edu.br/TimeServer/getTimeAsElapsedResponse")
    public long getTimeAsElapsed();
}
