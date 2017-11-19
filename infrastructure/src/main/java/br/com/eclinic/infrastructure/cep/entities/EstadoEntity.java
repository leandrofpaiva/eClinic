package br.com.eclinic.infrastructure.cep.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: Estado
 * 
 * @author javadev
 * @version 1.0
 *
 */
@Entity
@Table(name = "TB_ESTADOS")
public class EstadoEntity implements Serializable {

	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", length = 11)
    private Integer id;
	
    @Column(name = "UF_ID", length = 11)
    private String uf_id;
	
    @Column(name = "NOME", length = 150)
    private String nome;
	
    @Column(name = "UF", length = 6)
    private String uf;
	
    @Column(name = "CAPITAL", length = 255)
    private String capital;
	
    @Column(name = "REGIAO", length = 255)
    private String regiao;
	
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
	
    public EstadoEntity() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getUf_id() {
        return uf_id;
    }

    public void setUf_id(String uf_id) {
        this.uf_id = uf_id;
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
    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }
    public String getRegiao() {
        return regiao;
    }

    public void setRegiao(String regiao) {
        this.regiao = regiao;
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
