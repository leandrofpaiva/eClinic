package br.com.eclinic.domain.cep;

import java.io.Serializable;

/**
 * Domain class: Estado
 * 
 * @author javadev
 * @version 1.0
 *
 */
public class Estado implements Serializable {

	private static final long serialVersionUID = 1L;

    private Integer id;
	
    private String uf_id;
	
    private String nome;
	
    private String uf;
	
    private String capital;
	
    private String regiao;
	
    private String latitude;
	
    private String longitude;
	
    private String faixainicial1;
	
    private String faixafinal1;
	
    private String faixainicial2;
	
    private String faixafinal2;
	
    public Estado() {
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
