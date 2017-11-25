package br.com.javadev.eclinic.domain.core;

import br.com.javadev.eclinic.domain.config.Status;
import br.com.javadev.eclinic.domain.types.Cpf;
import br.com.javadev.eclinic.domain.types.Telefone;

public class Profissional {

	private Long id;

	private String nome;

	private Cpf cpf;

	private Telefone contato;

	private Cargo cargo;

	private Especialidade especialidade;

	private String crm;

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

	public Cpf getCpf() {
		return cpf;
	}

	public void setCpf(Cpf cpf) {
		this.cpf = cpf;
	}

	public Telefone getContato() {
		return contato;
	}

	public void setContato(Telefone contato) {
		this.contato = contato;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public Especialidade getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(Especialidade especialidade) {
		this.especialidade = especialidade;
	}

	public String getCrm() {
		return crm;
	}

	public void setCrm(String crm) {
		this.crm = crm;
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
