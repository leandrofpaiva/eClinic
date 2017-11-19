package br.com.eclinic.domain.config;

/**
 * Status
 * 
 * @author uteam
 * @version 1.0
 *
 */
public class Status {

	private long id;

	private String nome;

	private String descricao;

	private int ativo;

	public Status() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getAtivo() {
		return ativo;
	}

	public void setAtivo(int ativo) {
		this.ativo = ativo;
	}

}
