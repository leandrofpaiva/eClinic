package br.com.eclinic.infrastructure.security.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author javadev
 * 
 */
@Entity
@Table(name = "AUDIT")
public class AuditEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "msg_id")
	private Integer id;
	
	@Column(nullable = false)
	private String text;
	
	@Column(name = "created_on")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdOn = new Date();
	
	@ManyToOne
	@JoinColumn(name = "posted_by")
	private UserEntity postedBy;

	public AuditEntity() {
	}

	public AuditEntity(Integer id, String text) {
		this.id = id;
		this.text = text;
	}

	public AuditEntity(Integer id, String text, Date createdOn) {
		this.id = id;
		this.text = text;
		this.createdOn = createdOn;
	}

	public AuditEntity(Integer id, String text, UserEntity postedBy) {
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

	public UserEntity getPostedBy() {
		return postedBy;
	}

	public void setPostedBy(UserEntity postedBy) {
		this.postedBy = postedBy;
	}

}
