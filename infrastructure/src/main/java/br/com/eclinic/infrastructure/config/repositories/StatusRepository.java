package br.com.eclinic.infrastructure.config.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.eclinic.infrastructure.config.entities.StatusEntity;

/**
 * @author uteam
 * 
 */
public interface StatusRepository extends
		JpaRepository<StatusEntity, Integer> {

	@Override
	@Query("select c from #{#entityName} c where ativo = 1")
	public List<StatusEntity> findAll();

}
