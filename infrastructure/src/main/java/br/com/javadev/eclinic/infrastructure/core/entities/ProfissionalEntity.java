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

import br.com.javadev.eclinic.domain.types.Cpf;
import br.com.javadev.eclinic.domain.types.Telefone;
import br.com.javadev.eclinic.infrastructure.config.entities.StatusEntity;

@Entity
@Table(name = "TB_PROFISSIONAL")
public class ProfissionalEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", length = 11)
	private Long id;

	@Column(name = "NOME", length = 45)
	private String nome;

	@Embedded
	private Cpf cpf;

	@Embedded
	private Telefone contato;

	@Column(name = "CRM", length = 20)
	private String crm;

	@OneToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "ID_CARGO", nullable = true, insertable = true, updatable = true)
	private CargoEntity cargo;

	@OneToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "ID_ESPECIALIDADE", nullable = true, insertable = true, updatable = true)
	private EspecialidadeEntity especialidade;

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

	public String getCrm() {
		return crm;
	}

	public void setCrm(String crm) {
		this.crm = crm;
	}

	public CargoEntity getCargo() {
		return cargo;
	}

	public void setCargo(CargoEntity cargo) {
		this.cargo = cargo;
	}

	public EspecialidadeEntity getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(EspecialidadeEntity especialidade) {
		this.especialidade = especialidade;
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
