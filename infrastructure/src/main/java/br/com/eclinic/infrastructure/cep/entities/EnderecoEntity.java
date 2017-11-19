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
 * Entity implementation class for Entity: Endereco
 * 
 * @author javadev
 * @version 1.0
 *
 */
@Entity
@Table(name = "TB_ENDERECOS")
public class EnderecoEntity implements Serializable {

	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", length = 11)
    private Integer id;
	
    @Column(name = "UF", length = 5)
    private String uf;
	
    @Column(name = "CIDADE_ID", length = 15)
    private String cidade_id;
	
    @Column(name = "CIDADE_NOME", length = 255)
    private String cidade_nome;
	
    @Column(name = "NOMESLOG", length = 255)
    private String nomeslog;
	
    @Column(name = "NOMECLOG", length = 255)
    private String nomeclog;
	
    @Column(name = "BAIRRO_NOME", length = 255)
    private String bairro_nome;
	
    @Column(name = "LOGRADOURO", length = 255)
    private String logradouro;
	
    @Embedded
    private Cep cep;
	
    @Column(name = "LOGRACOMPL", length = 255)
    private String logracompl;
	
    @Column(name = "LATITUDE", length = 255)
    private String latitude;
	
    @Column(name = "LONGITUDE", length = 255)
    private String longitude;
	
    public EnderecoEntity() {
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
