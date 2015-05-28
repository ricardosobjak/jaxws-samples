package br.edu.utfpr.jaxws.times;

import java.util.Set;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import br.edu.utfpr.jaxws.times.model.Jogador;
import br.edu.utfpr.jaxws.times.model.Time;

public class TimesUtility {
	private Map<String, Time> times;

	public TimesUtility() {
		times = new HashMap<String, Time>();
		fabricarTimes();
	}

	public Time getTimes(String nome) {
		return this.times.get(nome);
	}

	public List<Time> getTimes() {
		List<Time> list = new ArrayList<>();
		Set<String> keys = this.times.keySet();
		for (String key : keys)
			list.add(this.times.get(key));
		return list;
	}

	/**
	 * Criar os times e os jogadores.
	 */
	public void fabricarTimes() {
		List<Time> times = new ArrayList<Time>();

		Jogador marco = new Jogador("Marcos Silva", "Marco");
		Jogador guto = new Jogador("Gustavo Burns", "Guto");
		
		List<Jogador> jogadores1 = new ArrayList<Jogador>();
		jogadores1.add(marco);
		jogadores1.add(guto);
		times.add( new Time("Time 1", jogadores1) );

		Jogador willian = new Jogador("William Abrão", "Willian");
		Jogador luiz = new Jogador("Luiz Carrilho", "Luiz");
		List<Jogador> jogadores2 = new ArrayList<Jogador>();
		jogadores2.add(willian);
		jogadores2.add(luiz);
		times.add( new Time("Time 2", jogadores2) );

		Jogador chico = new Jogador("Francisco Mark", "Chico");
		Jogador julio = new Jogador("Julio Mark", "Julio");
		List<Jogador> jogadores3 = new ArrayList<Jogador>();
		jogadores3.add(chico);
		jogadores3.add(julio);
		times.add(new Time("Time 3", jogadores3));

		gravarTime(times);
	}

	/**
	 * Grava um Time no MAPA. 
	 */
	private void gravarTime(List<Time> times) {
		for (Time time : times)
			this.times.put(time.getNome(), time);
	}
}
