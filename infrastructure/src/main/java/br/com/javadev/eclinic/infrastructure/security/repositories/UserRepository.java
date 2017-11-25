package br.com.javadev.eclinic.infrastructure.security.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.javadev.eclinic.domain.types.Email;
import br.com.javadev.eclinic.infrastructure.security.entities.UserEntity;

/**
 * @author javadev
 * 
 */
public interface UserRepository extends JpaRepository<UserEntity, Integer>
{

	UserEntity findByEmail(Email email);

	UserEntity findByUserName(String userName);

	UserEntity findByUserNameAndPassword(String userName, String password);

}
