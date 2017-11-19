package br.com.eclinic.infrastructure.cep.business;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.eclinic.domain.cep.Endereco;
import br.com.eclinic.domain.types.Cep;
import br.com.eclinic.infrastructure.cep.business.interfaces.IEnderecoBusiness;
import br.com.eclinic.infrastructure.cep.entities.EnderecoEntity;
import br.com.eclinic.infrastructure.cep.repositories.EnderecoRepository;

/**
 * Classe de Servico - EnderecosBusiness
 * 
 * @author javadev
 */
@Component
public class EnderecoBusiness implements IEnderecoBusiness {

	/**
	 * Entity Manager
	 */
	@PersistenceContext
	private EntityManager em;

	/**
	 * Repository
	 */
	@Autowired
	private EnderecoRepository repository;

	@Override
	public Endereco create(Endereco endereco) {
		EnderecoEntity enderecoEntity = new EnderecoEntity();
		BeanUtils.copyProperties(endereco, enderecoEntity);
		enderecoEntity = repository.save(enderecoEntity);
		BeanUtils.copyProperties(enderecoEntity, endereco);
		return endereco;
	}

	@Override
	public EnderecoEntity read(Integer id) {
		return repository.findOne(id);
	}

	@Override
	public Endereco update(Endereco endereco) {
		EnderecoEntity enderecoEntity = new EnderecoEntity();
		BeanUtils.copyProperties(endereco, enderecoEntity);
		enderecoEntity = repository.save(enderecoEntity);
		BeanUtils.copyProperties(enderecoEntity, endereco);
		return endereco;
	}

	@Override
	public void delete(Integer id) {
		repository.delete(id);
	}

	@Override
	public List<Endereco> list() {
		List<EnderecoEntity> listEnderecosEntities = repository.findAll();

		List<Endereco> listEnderecos = new ArrayList<Endereco>();

		for (EnderecoEntity enderecoEntity : listEnderecosEntities) {
			Endereco endereco = new Endereco();
			BeanUtils.copyProperties(enderecoEntity, endereco);
			listEnderecos.add(endereco);
		}

		return listEnderecos;
	}

	/**
	 * Retorna o Cep informado
	 * 
	 * @return EnderecoEntity
	 */
	public Endereco findByCep(Cep cep) {
		EnderecoEntity enderecoEntity = repository.findByCep(cep);
		Endereco endereco = new Endereco();
		BeanUtils.copyProperties(enderecoEntity, endereco);
		return endereco;
	}
}
