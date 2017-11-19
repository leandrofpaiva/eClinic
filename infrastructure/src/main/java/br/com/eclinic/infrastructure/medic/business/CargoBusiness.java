package br.com.eclinic.infrastructure.medic.business;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.eclinic.domain.config.Status;
import br.com.eclinic.domain.medic.Cargo;
import br.com.eclinic.infrastructure.config.entities.StatusEntity;
import br.com.eclinic.infrastructure.medic.business.interfaces.ICargoBusiness;
import br.com.eclinic.infrastructure.medic.entities.CargoEntity;
import br.com.eclinic.infrastructure.medic.repositories.CargoRepository;

/**
 * Classe Business - CargoBusiness
 * 
 * @author javadev
 */
@Component
public class CargoBusiness implements ICargoBusiness {

	/**
	 * Entity Manager
	 */
	@PersistenceContext
	private EntityManager em;

	/**
	 * Repository
	 */
	@Autowired
	private CargoRepository repository;

	@Override
	public Cargo gravar(Cargo Cargo) {
		CargoEntity CargoEntity = new CargoEntity();
		BeanUtils.copyProperties(Cargo, CargoEntity);

		/* Setando o status */
		if (Cargo.getStatus() != null) {
			StatusEntity statusEntity = new StatusEntity();
			BeanUtils.copyProperties(Cargo.getStatus(), statusEntity);
			CargoEntity.setStatus(statusEntity);
		}

		repository.save(CargoEntity);
		Cargo.setId(CargoEntity.getId());
		return Cargo;
	}

	@Override
	public Cargo consultar(Integer id) {
		Cargo Cargo = new Cargo();
		CargoEntity CargoEntity = repository.findOne(id);
		BeanUtils.copyProperties(CargoEntity, Cargo);

		/* Setando o status */
		Status status = new Status();
		BeanUtils.copyProperties(CargoEntity.getStatus(), status);
		Cargo.setStatus(status);

		return Cargo;
	}

	@Override
	public void excluir(Integer id) {
		repository.delete(id);
	}

	@Override
	public List<Cargo> listarTodos() {
		List<Cargo> listaCargo = new ArrayList<Cargo>();
		List<CargoEntity> listaCargoEntities = repository
				.findAll();

		for (CargoEntity CargoEntity : listaCargoEntities) {
			Cargo Cargo = new Cargo();
			BeanUtils.copyProperties(CargoEntity, Cargo);

			/* Setando o status da Cargo */
			Status status = new Status();
			if (CargoEntity.getStatus() != null) {
				BeanUtils
						.copyProperties(CargoEntity.getStatus(), status);
				Cargo.setStatus(status);
			}

			listaCargo.add(Cargo);
		}

		return listaCargo;
	}

	@Override
	public List<Cargo> listarTodosCombo() {
		List<Cargo> listaCargo = new ArrayList<Cargo>();
		List<CargoEntity> listaCargoEntities = repository.list();

		for (CargoEntity CargoEntity : listaCargoEntities) {
			Cargo Cargo = new Cargo();
			BeanUtils.copyProperties(CargoEntity, Cargo);

			/* Setando o status da Cargo */
			Status status = new Status();
			if (CargoEntity.getStatus() != null) {
				BeanUtils
						.copyProperties(CargoEntity.getStatus(), status);
				Cargo.setStatus(status);
			}

			listaCargo.add(Cargo);
		}

		return listaCargo;
	}
}
