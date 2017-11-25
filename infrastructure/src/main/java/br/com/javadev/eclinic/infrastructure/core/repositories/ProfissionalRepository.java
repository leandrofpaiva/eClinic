package br.com.javadev.eclinic.infrastructure.core.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.javadev.eclinic.infrastructure.core.entities.ProfissionalEntity;

/**
 * @author javadev
 * 
 */
public interface ProfissionalRepository extends
		JpaRepository<ProfissionalEntity, Integer> {

	@Override
	@Query("select c from #{#entityName} c where ativo = 1")
	public List<ProfissionalEntity> findAll();

	@Query("select c from #{#entityName} c where id_status = 1 and ativo = 1")
	public List<ProfissionalEntity> list();
}
