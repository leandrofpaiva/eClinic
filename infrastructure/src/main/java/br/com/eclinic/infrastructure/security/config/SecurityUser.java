/**
 * 
 */
package br.com.eclinic.infrastructure.security.config;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import br.com.eclinic.infrastructure.security.entities.RoleEntity;
import br.com.eclinic.infrastructure.security.entities.UserEntity;

/**
 * @author javadev
 *
 */
public class SecurityUser extends org.springframework.security.core.userdetails.User
{
	private static final long serialVersionUID = 1L;
	private UserEntity domainUser = new UserEntity();
	
	public SecurityUser(UserEntity user) {
		super(user.getUserName(), user.getPassword(), getGrantedAuthorities(user));
		this.domainUser = user;
	}
	
	public SecurityUser(String username, String password,
			Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
		this.domainUser.setUserName(username);
		this.domainUser.setPassword(password);
		this.domainUser.setRoles(getRoles(authorities));
	}
	
	public SecurityUser(String username, String password, boolean enabled,
			boolean accountNonExpired, boolean credentialsNonExpired,
			boolean accountNonLocked,
			Collection<? extends GrantedAuthority> authorities) {
		super(username, password, enabled, accountNonExpired, credentialsNonExpired,
				accountNonLocked, authorities);
		this.domainUser.setUserName(username);
		this.domainUser.setPassword(password);
		this.domainUser.setRoles(getRoles(authorities));
	}

	public static List<GrantedAuthority> getGrantedAuthorities(UserEntity user) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		for (RoleEntity role : user.getRoles()) {
			authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
		}
		return authorities;
	}

	public static Set<RoleEntity> getRoles(Collection<? extends GrantedAuthority> authorities) {
		Set<RoleEntity> roles = new HashSet<>();
		for (GrantedAuthority authority : authorities) {
			String roleName = authority.getAuthority();
			roles.add(new RoleEntity(roleName));
		}
		return roles;
	}

	public UserEntity getDomainUser() {
		return domainUser;
	}
}
