package br.com.javadev.eclinic.infrastructure.config.business;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.javadev.eclinic.domain.config.Status;
import br.com.javadev.eclinic.infrastructure.config.business.interfaces.IStatusBusiness;
import br.com.javadev.eclinic.infrastructure.config.entities.StatusEntity;
import br.com.javadev.eclinic.infrastructure.config.repositories.StatusRepository;

/**
 * Classe Business - StatusBusiness
 * 
 * @author javadev
 */
@Component
public class StatusBusiness implements IStatusBusiness {

	/**
	 * Entity Manager
	 */
	@PersistenceContext
	private EntityManager em;

	/**
	 * Repository
	 */
	@Autowired
	private StatusRepository repository;

	@Override
	public Status gravar(Status status) {
		StatusEntity statusEntity = new StatusEntity();
		BeanUtils.copyProperties(status, statusEntity);
		repository.save(statusEntity);
		status.setId(statusEntity.getId());
		return status;
	}

	@Override
	public Status consultar(Integer id) {
		Status status = new Status();
		StatusEntity statusEntity = repository.findOne(id);
		BeanUtils.copyProperties(statusEntity, status);
		return status;
	}

	@Override
	public void excluir(Integer id) {
		repository.delete(id);
	}

	@Override
	public List<Status> listarTodos() {
		List<Status> listaStatuss = new ArrayList<Status>();
		List<StatusEntity> listaStatussEntities = repository.findAll();

		for (StatusEntity statusEntity : listaStatussEntities) {
			Status status = new Status();
			BeanUtils.copyProperties(statusEntity, status);
			listaStatuss.add(status);
		}

		return listaStatuss;
	}

}
