package br.com.eclinic.infrastructure.cep.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.eclinic.infrastructure.cep.entities.CidadeEntity;

/**
 * @author javadev
 * 
 */
public interface CidadeRepository extends JpaRepository<CidadeEntity, Integer> {

}
