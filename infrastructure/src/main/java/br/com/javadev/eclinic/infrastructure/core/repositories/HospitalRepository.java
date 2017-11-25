package br.com.javadev.eclinic.infrastructure.core.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.javadev.eclinic.infrastructure.core.entities.HospitalEntity;

/**
 * @author javadev
 * 
 */
public interface HospitalRepository extends
		JpaRepository<HospitalEntity, Integer> {

	@Override
	@Query("select c from #{#entityName} c where ativo = 1")
	public List<HospitalEntity> findAll();

	@Query("select c from #{#entityName} c where id_status = 1 and ativo = 1")
	public List<HospitalEntity> list();
}
