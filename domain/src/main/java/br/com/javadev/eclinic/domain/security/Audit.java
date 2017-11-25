package br.com.javadev.eclinic.domain.security;

import java.io.Serializable;
import java.util.Date;

/**
 * @author javadev
 * 
 */
public class Audit implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Integer id;
	
	private String text;
	
	private Date createdOn = new Date();
	
	private User postedBy;

	public Audit() {
	}

	public Audit(Integer id, String text) {
		this.id = id;
		this.text = text;
	}

	public Audit(Integer id, String text, Date createdOn) {
		this.id = id;
		this.text = text;
		this.createdOn = createdOn;
	}

	public Audit(Integer id, String text, User postedBy) {
		this.id = id;
		this.text = text;
		this.postedBy = postedBy;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public User getPostedBy() {
		return postedBy;
	}

	public void setPostedBy(User postedBy) {
		this.postedBy = postedBy;
	}

}
