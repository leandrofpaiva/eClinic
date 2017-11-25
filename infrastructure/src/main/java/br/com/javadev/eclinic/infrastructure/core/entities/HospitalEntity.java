package br.com.javadev.eclinic.infrastructure.core.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.javadev.eclinic.domain.types.Cnpj;
import br.com.javadev.eclinic.domain.types.Telefone;
import br.com.javadev.eclinic.infrastructure.config.entities.StatusEntity;

@Entity
@Table(name = "TB_HOSPITAL")
public class HospitalEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", length = 11)
	private Long id;

	@Column(name = "NOME", length = 45)
	private String nome;

	@Embedded
	private Cnpj cnpj;

	@Embedded
	private Telefone contato;

	@OneToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "ID_STATUS", nullable = true, insertable = true, updatable = true)
	private StatusEntity status;

	@Column(name = "ATIVO", nullable = true, length = 1)
	private int ativo = 1;

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

	public StatusEntity getStatus() {
		return status;
	}

	public void setStatus(StatusEntity status) {
		this.status = status;
	}

	public int getAtivo() {
		return ativo;
	}

	public void setAtivo(int ativo) {
		this.ativo = ativo;
	}

}
