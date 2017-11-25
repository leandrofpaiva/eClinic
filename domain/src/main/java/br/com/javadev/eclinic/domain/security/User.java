package br.com.javadev.eclinic.domain.security;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import br.com.javadev.eclinic.domain.types.Email;

/**
 * @author javadev
 * 
 */
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	private String userName;
	
	private String password;
	
	private String firstName;
	
	private String lastName;
	
	private Email email;
	
	private Date dob;
	
	private boolean enabled = true;

	private Set<Role> roles = new HashSet<>();

	private List<Audit> messages = new ArrayList<>();

	public User() {
	}

	public User(Integer id) {
		this.id = id;
	}

	public User(Integer id, String userName, String password, String firstName,
			String email) {
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.email = Email.fromString(email);
	}

	public User(Integer id, String userName, String password, String firstName,
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

	public List<Audit> getMessages() {
		return messages;
	}

	public void setMessages(List<Audit> messages) {
		this.messages = messages;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public void addRoles(Role... roles) {
		this.roles.addAll(Arrays.asList(roles));
	}

}
