package br.com.javadev.eclinic.application.data;

import java.sql.Connection;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class LoadDatabase implements CommandLineRunner {

	@Autowired
	private DataSource dataSource;

	/**
	 * Iniciando o login admin no heroku
	 * 
	 */
	@Override
	public void run(String... args) throws Exception {

		try (Connection connection = dataSource.getConnection()) {
			Statement stmt = connection.createStatement();

			stmt.executeUpdate("INSERT INTO users (id, dob, email, enabled, firstname, lastname, password, username) VALUES (1, '2016-05-01', 'admin@uppersolutions.com.br', TRUE, 'Leandro', 'Fernandes', '12345', 'admin@uppersolutions.com.br')");
			stmt.executeUpdate("INSERT INTO authorities (role_id, authority, user_id) VALUES (1, 'ADMIN', 1)");

		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
}
