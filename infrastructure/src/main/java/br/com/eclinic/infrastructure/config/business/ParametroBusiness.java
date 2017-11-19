package br.com.eclinic.infrastructure.config.business;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.eclinic.domain.config.Parametro;
import br.com.eclinic.infrastructure.config.business.interfaces.IParametroBusiness;
import br.com.eclinic.infrastructure.config.entities.ParametroEntity;
import br.com.eclinic.infrastructure.config.repositories.ParametroRepository;

/**
 * Classe Business - ParametroBusiness
 * 
 * @author javadev
 */
@Component
public class ParametroBusiness implements IParametroBusiness {

	/**
	 * Entity Manager
	 */
	@PersistenceContext
	private EntityManager em;

	/**
	 * Repository
	 */
	@Autowired
	private ParametroRepository repository;

	@Override
	public Parametro gravar(Parametro parametro) {
		ParametroEntity parametroEntity = new ParametroEntity();
		BeanUtils.copyProperties(parametro, parametroEntity);
		repository.save(parametroEntity);
		parametro.setId(parametroEntity.getId());
		return parametro;
	}

	@Override
	public Parametro consultar(Integer id) {
		Parametro parametro = new Parametro();
		ParametroEntity parametroEntity = repository.findOne(id);
		BeanUtils.copyProperties(parametroEntity, parametro);
		return parametro;
	}

	@Override
	public void excluir(Integer id) {
		repository.delete(id);
	}

	@Override
	public List<Parametro> listarTodos() {
		List<Parametro> listaParametros = new ArrayList<Parametro>();
		List<ParametroEntity> listaParametrosEntities = repository.findAll();

		for (ParametroEntity parametroEntity : listaParametrosEntities) {
			Parametro parametro = new Parametro();
			BeanUtils.copyProperties(parametroEntity, parametro);
			listaParametros.add(parametro);
		}

		return listaParametros;
	}

}
