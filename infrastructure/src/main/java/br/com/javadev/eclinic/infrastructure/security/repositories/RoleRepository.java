package br.com.javadev.eclinic.infrastructure.security.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.javadev.eclinic.infrastructure.security.entities.RoleEntity;

/**
 * @author javadev
 * 
 */
public interface RoleRepository extends JpaRepository<RoleEntity, Integer>
{

}
