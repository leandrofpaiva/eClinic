package br.com.eclinic.infrastructure.config.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.eclinic.infrastructure.config.entities.ParametroEntity;

/**
 * @author uteam
 * 
 */
public interface ParametroRepository extends
		JpaRepository<ParametroEntity, Integer> {

}
