package br.edu.utfpr.jaxws.times.service;

import java.util.List;

import javax.jws.WebService;

import br.edu.utfpr.jaxws.times.TimesUtility;
import br.edu.utfpr.jaxws.times.model.Time;

@WebService( endpointInterface="br.edu.utfpr.jaxws.times.service.Times")
public class TimesImpl implements Times {
	private TimesUtility utils;

	public TimesImpl() {
		utils = new TimesUtility();
		utils.fabricarTimes();
	}

	public Time getTime(String name) {
		return utils.getTimes(name);
	}

	public List<Time> getTimes() {
		return utils.getTimes();
	}
}
