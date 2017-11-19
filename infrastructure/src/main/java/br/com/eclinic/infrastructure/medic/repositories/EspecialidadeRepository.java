package br.com.eclinic.infrastructure.medic.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.eclinic.infrastructure.medic.entities.EspecialidadeEntity;

/**
 * @author javadev
 * 
 */
public interface EspecialidadeRepository extends
		JpaRepository<EspecialidadeEntity, Integer> {

	@Override
	@Query("select c from #{#entityName} c where ativo = 1")
	public List<EspecialidadeEntity> findAll();

	@Query("select c from #{#entityName} c where id_status = 1 and ativo = 1")
	public List<EspecialidadeEntity> list();
}
