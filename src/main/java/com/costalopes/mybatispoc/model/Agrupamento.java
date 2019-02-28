package com.costalopes.mybatispoc.model;

public class Agrupamento {

	private int id_agrupamento;
	private String nome;
	private int chave;

	public int getId_agrupamento() {
		return id_agrupamento;
	}

	public void setId_agrupamento(int id_agrupamento) {
		this.id_agrupamento = id_agrupamento;
	}

	public int getChave() {
		return chave;
	}

	public void setChave(int chave) {
		this.chave = chave;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Agrupamento [id_agrupamento=" + id_agrupamento + ", nome=" + nome + ", chave=" + chave + "]";
	}

}
