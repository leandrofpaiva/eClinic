package br.com.eclinic.api.security.services;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthService {

	@Autowired
	private UserDetailsService userDetailsService;

	public AuthService() {
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public LoginResponse login(@RequestBody final UserLogin login)
			throws ServletException {

		System.out.println("login: " + login.email);

		// Usuario usuario = usuarioBusiness.findByEmail(Email
		// .fromString(login.name));

		UserDetails userDetails = userDetailsService
				.loadUserByUsername(login.email);

		System.out.println("1: " + userDetails.getAuthorities());
		System.out.println("1: " + userDetails.getUsername());
		System.out.println("1: " + userDetails.getPassword() + ".");
		System.out.println("1: " + login.password + ".");

		if (login.email == null || userDetails == null
				|| !userDetails.getPassword().equals(login.password)) {
			throw new ServletException("Invalid login");
		}

		return new LoginResponse(Jwts.builder().setSubject(login.email)
				.claim("roles", userDetails.getAuthorities())
				.setIssuedAt(new Date())
				.signWith(SignatureAlgorithm.HS256, "secretkey").compact());
	}

	private static class UserLogin {
		public String email;
		public String password;
	}

	@SuppressWarnings("unused")
	private static class LoginResponse {
		public String token;

		public LoginResponse(final String token) {
			this.token = token;
		}
	}

}