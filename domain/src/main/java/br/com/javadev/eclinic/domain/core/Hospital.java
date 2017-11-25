package br.com.javadev.eclinic.domain.core;

import br.com.javadev.eclinic.domain.config.Status;
import br.com.javadev.eclinic.domain.types.Cnpj;
import br.com.javadev.eclinic.domain.types.Telefone;

public class Hospital {

	private Long id;

	private String nome;

	private Cnpj cnpj;

	private Telefone contato;

	private Status status;

	private int ativo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Cnpj getCnpj() {
		return cnpj;
	}

	public void setCnpj(Cnpj cnpj) {
		this.cnpj = cnpj;
	}

	public Telefone getContato() {
		return contato;
	}

	public void setContato(Telefone contato) {
		this.contato = contato;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public int getAtivo() {
		return ativo;
	}

	public void setAtivo(int ativo) {
		this.ativo = ativo;
	}
}
