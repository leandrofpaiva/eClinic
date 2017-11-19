package br.com.eclinic.infrastructure.security.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.eclinic.infrastructure.security.entities.RoleEntity;

/**
 * @author javadev
 * 
 */
public interface RoleRepository extends JpaRepository<RoleEntity, Integer>
{

}
