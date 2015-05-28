package br.edu.utfpr.jaxws.times.model;

import java.util.List;

public class Time {
	private List<Jogador> jogadores;
	private String nome;

	public Time() {
	}

	public Time(String nome, List<Jogador> jogadores) {
		setNome(nome);
		setJogadores(jogadores);
	}

	public void setNome(String name) {
		this.nome = name;
	}

	public String getNome() {
		return nome;
	}

	public void setJogadores(List<Jogador> players) {
		this.jogadores = players;
	}

	public List<Jogador> getJogadores() {
		return jogadores;
	}

	public void setListaCount(int n) {
	} // no-op but needed for property

	public int getListaCount() {
		return (jogadores == null) ? 0 : jogadores.size();
	}
}
