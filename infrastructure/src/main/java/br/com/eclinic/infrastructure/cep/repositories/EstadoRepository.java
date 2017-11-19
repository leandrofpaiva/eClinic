package br.com.eclinic.infrastructure.cep.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.eclinic.infrastructure.cep.entities.EstadoEntity;

/**
 * @author Leandro Fernandes
 * 
 */
public interface EstadoRepository extends JpaRepository<EstadoEntity, Integer> {

}
