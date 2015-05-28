package br.edu.utfpr.ws.timeserver;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.jws.WebService;

@WebService(endpointInterface = "br.edu.utfpr.ws.timeserver.TimeServer", serviceName="TempoService")
public class TimeServerImpl implements TimeServer {
	public String getTimeAsString() {
		return new Date().toString();
	}
	public long getTimeAsElapsed() {
		return new Date().getTime();
	}
	public String getNameOfMonth(int month) {
		Date data = new Date();
		data.setMonth(month-1);
		SimpleDateFormat sdf = new SimpleDateFormat("MMMMMMMMMMMMM");
		return sdf.format(data);
	}
}