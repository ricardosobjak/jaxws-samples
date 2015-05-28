package br.edu.utfpr.jaxws.times.service;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import br.edu.utfpr.jaxws.times.model.Time;

@WebService
@SOAPBinding(style = Style.DOCUMENT)
public interface Times {

	@WebMethod
	public Time getTime(String nome);

	@WebMethod
	public List<Time> getTimes();
}
