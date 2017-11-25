package br.com.javadev.eclinic.infrastructure.security.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.javadev.eclinic.domain.types.Email;

/**
 * @author javadev
 * 
 */
@Entity
@Table(name = "USERS")
public class UserEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name = "user_id")
	private Integer id;
	
	@Column(name = "username", nullable = false, unique = true, length = 50)
	private String userName;
	
	@Column(name = "password", nullable = false, length = 50)
	private String password;
	
	@Column(name = "firstname", nullable = false, length = 50)
	private String firstName;
	
	@Column(name = "lastname", length = 50)
	private String lastName;
	
	@Embedded
	private Email email;
	
	@Temporal(TemporalType.DATE)
	private Date dob;
	
	private boolean enabled = true;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private Set<RoleEntity> roles = new HashSet<>();

	@OneToMany(mappedBy = "postedBy")
	@XmlTransient
	@JsonIgnore
	private List<AuditEntity> messages = new ArrayList<>();

	public UserEntity() {
	}

	public UserEntity(Integer id) {
		this.id = id;
	}

	public UserEntity(Integer id, String userName, String password, String firstName,
			String email) {
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.email = Email.fromString(email);
	}

	public UserEntity(Integer id, String userName, String password, String firstName,
			String lastName, String email, Date dob) {
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = Email.fromString(email);
		this.dob = dob;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Email getEmail() {
		return email;
	}

	public void setEmail(Email email) {
		this.email = email;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public List<AuditEntity> getMessages() {
		return messages;
	}

	public void setMessages(List<AuditEntity> messages) {
		this.messages = messages;
	}

	public Set<RoleEntity> getRoles() {
		return roles;
	}

	public void setRoles(Set<RoleEntity> roles) {
		this.roles = roles;
	}

	public void addRoles(RoleEntity... roles) {
		this.roles.addAll(Arrays.asList(roles));
	}

}
