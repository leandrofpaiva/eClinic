package br.com.eclinic.infrastructure.cep.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.eclinic.domain.types.Cep;
import br.com.eclinic.infrastructure.cep.entities.EnderecoEntity;

/**
 * @author javadev
 * 
 */
public interface EnderecoRepository extends JpaRepository<EnderecoEntity, Integer> {

	public EnderecoEntity findByCep(Cep cep);

}
