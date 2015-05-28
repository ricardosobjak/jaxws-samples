package br.edu.utfpr.ws.timeserver;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService
@SOAPBinding(style = Style.RPC)
public interface TimeServer {
	@WebMethod
	public String getTimeAsString();

	@WebMethod
	public long getTimeAsElapsed();
	
	@WebMethod
	public String getNameOfMonth(@WebParam int month);
}