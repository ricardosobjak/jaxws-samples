package br.edu.utfpr.jaxws.times.model;

public class Jogador {
	private String nome;
	private String apelido;

	public Jogador() {
	}

	public Jogador(String nome, String apelido) {
		setNome(nome);
		setApelido(apelido);
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

	public String getApelido() {
		return apelido;
	}
}
