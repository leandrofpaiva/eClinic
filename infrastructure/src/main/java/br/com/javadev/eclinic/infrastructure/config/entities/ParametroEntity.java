package br.com.javadev.eclinic.infrastructure.config.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: ParametroEntity
 * 
 * @author javadev
 * @version 1.0
 *
 */
@Entity
@Table(name = "TB_PARAMETRO")
public class ParametroEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", length = 11)
	private long id;

	@Column(name = "NOME", nullable = false, length = 60)
	private String nome;

	@Column(name = "DESCRICAO", nullable = true, length = 150)
	private String descricao;

	@Column(name = "VALOR", nullable = true, length = 80)
	private String valor;

	@Column(name = "ATIVO", nullable = true, length = 1)
	private int ativo = 1;

	public ParametroEntity() {
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

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public int getAtivo() {
		return ativo;
	}

	public void setAtivo(int ativo) {
		this.ativo = ativo;
	}

}
