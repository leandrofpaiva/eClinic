/**
 * 
 */
package br.com.javadev.eclinic.infrastructure.security.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Siva
 *
 */
@Entity
@Table(name = "AUTHORITIES")
public class RoleEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "role_id")
	private Integer id;
	
	// @Column(name="username", nullable=false)
	// private String userName;
	
	@Column(name = "authority", nullable = false)
	private String roleName;

	public RoleEntity() {
	}

	public RoleEntity(String roleName) {
		this.roleName = roleName;
	}

	public RoleEntity(Integer id, String roleName) {
		this.id = id;
		this.roleName = roleName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

}
