/**
 * 
 */
package br.com.eclinic.infrastructure.security.config;

/**
 * @author javadev
 *
 */
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.eclinic.infrastructure.security.entities.RoleEntity;
import br.com.eclinic.infrastructure.security.entities.UserEntity;
import br.com.eclinic.infrastructure.security.repositories.UserRepository;

@Service
@Transactional(readOnly = true)
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		try {
			System.out.println("CustomUserDetailsService - USERNAME: " + username);
			UserEntity domainUser = userRepository
					.findByUserName(username);
			return new SecurityUser(domainUser);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static List<GrantedAuthority> getGrantedAuthorities(
			UserEntity user) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		for (RoleEntity role : user.getRoles()) {
			authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
		}
		return authorities;
	}
}
