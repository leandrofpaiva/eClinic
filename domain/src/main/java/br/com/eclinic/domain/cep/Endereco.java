package br.com.eclinic.domain.cep;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

import br.com.eclinic.domain.types.Cep;

/**
 * Domain class: Endereco
 * 
 * @author javadev
 * @version 1.0
 *
 */
public class Endereco implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

	private String uf;

	private String cidade_id;

	private String cidade_nome;

	private String nomeslog;

	private String nomeclog;

	private String bairro_nome;

	private String logradouro;

	@JsonUnwrapped
	private Cep cep;

	private String logracompl;

	private String latitude;

	private String longitude;

	public Endereco() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getCidade_id() {
		return cidade_id;
	}

	public void setCidade_id(String cidade_id) {
		this.cidade_id = cidade_id;
	}

	public String getCidade_nome() {
		return cidade_nome;
	}

	public void setCidade_nome(String cidade_nome) {
		this.cidade_nome = cidade_nome;
	}

	public String getNomeslog() {
		return nomeslog;
	}

	public void setNomeslog(String nomeslog) {
		this.nomeslog = nomeslog;
	}

	public String getNomeclog() {
		return nomeclog;
	}

	public void setNomeclog(String nomeclog) {
		this.nomeclog = nomeclog;
	}

	public String getBairro_nome() {
		return bairro_nome;
	}

	public void setBairro_nome(String bairro_nome) {
		this.bairro_nome = bairro_nome;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public Cep getCep() {
		return cep;
	}

	public void setCep(Cep cep) {
		this.cep = cep;
	}

	public String getLogracompl() {
		return logracompl;
	}

	public void setLogracompl(String logracompl) {
		this.logracompl = logracompl;
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

}
