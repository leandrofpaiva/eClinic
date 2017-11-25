package br.com.javadev.eclinic.infrastructure.config.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.javadev.eclinic.infrastructure.config.entities.ParametroEntity;

/**
 * 
 * @author javadev
 */
public interface ParametroRepository extends
		JpaRepository<ParametroEntity, Integer> {

}
