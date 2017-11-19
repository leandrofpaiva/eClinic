package br.com.eclinic.infrastructure.cep.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.eclinic.domain.types.Cep;

/**
 * Entity implementation class for Entity: Cidade
 * 
 * @author Leandro Fernandes
 * @version 1.0
 *
 */
@Entity
@Table(name = "TB_CIDADES")
public class CidadeEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", length = 11)
	private Integer id;

	@Column(name = "CIDADE_ID", length = 255)
	private String cidade_id;

	@Column(name = "TIPO", length = 255)
	private String tipo;

	@Column(name = "NOME", length = 255)
	private String nome;

	@Column(name = "UF", length = 10)
	private String uf;

	@Column(name = "IBGE", length = 15)
	private String ibge;

	@Embedded
	private Cep cep;

	@Column(name = "POPULACAO", length = 255)
	private String populacao;

	@Column(name = "AREAKM", length = 20)
	private String areakm;

	@Column(name = "DENSIDADE", length = 255)
	private String densidade;

	@Column(name = "GENTILICO", length = 255)
	private String gentilico;

	@Column(name = "CAPITAL", length = 255)
	private String capital;

	@Column(name = "DISTANCIA_CAPITAL", length = 255)
	private String distancia_capital;

	@Column(name = "TEMPO_PERCURSO", length = 255)
	private String tempo_percurso;

	@Column(name = "LATITUDE", length = 255)
	private String latitude;

	@Column(name = "LONGITUDE", length = 255)
	private String longitude;

	@Column(name = "FAIXAINICIAL1", length = 255)
	private String faixainicial1;

	@Column(name = "FAIXAFINAL1", length = 255)
	private String faixafinal1;

	@Column(name = "FAIXAINICIAL2", length = 255)
	private String faixainicial2;

	@Column(name = "FAIXAFINAL2", length = 255)
	private String faixafinal2;

	public CidadeEntity() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCidade_id() {
		return cidade_id;
	}

	public void setCidade_id(String cidade_id) {
		this.cidade_id = cidade_id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getIbge() {
		return ibge;
	}

	public void setIbge(String ibge) {
		this.ibge = ibge;
	}

	public Cep getCep() {
		return cep;
	}

	public void setCep(Cep cep) {
		this.cep = cep;
	}

	public String getPopulacao() {
		return populacao;
	}

	public void setPopulacao(String populacao) {
		this.populacao = populacao;
	}

	public String getAreakm() {
		return areakm;
	}

	public void setAreakm(String areakm) {
		this.areakm = areakm;
	}

	public String getDensidade() {
		return densidade;
	}

	public void setDensidade(String densidade) {
		this.densidade = densidade;
	}

	public String getGentilico() {
		return gentilico;
	}

	public void setGentilico(String gentilico) {
		this.gentilico = gentilico;
	}

	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

	public String getDistancia_capital() {
		return distancia_capital;
	}

	public void setDistancia_capital(String distancia_capital) {
		this.distancia_capital = distancia_capital;
	}

	public String getTempo_percurso() {
		return tempo_percurso;
	}

	public void setTempo_percurso(String tempo_percurso) {
		this.tempo_percurso = tempo_percurso;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getFaixainicial1() {
		return faixainicial1;
	}

	public void setFaixainicial1(String faixainicial1) {
		this.faixainicial1 = faixainicial1;
	}

	public String getFaixafinal1() {
		return faixafinal1;
	}

	public void setFaixafinal1(String faixafinal1) {
		this.faixafinal1 = faixafinal1;
	}

	public String getFaixainicial2() {
		return faixainicial2;
	}

	public void setFaixainicial2(String faixainicial2) {
		this.faixainicial2 = faixainicial2;
	}

	public String getFaixafinal2() {
		return faixafinal2;
	}

	public void setFaixafinal2(String faixafinal2) {
		this.faixafinal2 = faixafinal2;
	}

}
