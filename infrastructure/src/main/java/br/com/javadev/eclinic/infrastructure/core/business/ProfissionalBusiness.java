package br.com.javadev.eclinic.infrastructure.core.business;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.javadev.eclinic.domain.config.Status;
import br.com.javadev.eclinic.domain.core.Cargo;
import br.com.javadev.eclinic.domain.core.Especialidade;
import br.com.javadev.eclinic.domain.core.Profissional;
import br.com.javadev.eclinic.infrastructure.config.entities.StatusEntity;
import br.com.javadev.eclinic.infrastructure.core.business.interfaces.IProfissionalBusiness;
import br.com.javadev.eclinic.infrastructure.core.entities.CargoEntity;
import br.com.javadev.eclinic.infrastructure.core.entities.EspecialidadeEntity;
import br.com.javadev.eclinic.infrastructure.core.entities.ProfissionalEntity;
import br.com.javadev.eclinic.infrastructure.core.repositories.ProfissionalRepository;

/**
 * Classe Business - ProfissionalBusiness
 * 
 * @author javadev
 */
@Component
public class ProfissionalBusiness implements IProfissionalBusiness {

	/**
	 * Entity Manager
	 */
	@PersistenceContext
	private EntityManager em;

	/**
	 * Repository
	 */
	@Autowired
	private ProfissionalRepository repository;

	@Override
	public Profissional gravar(Profissional profissional) {
		ProfissionalEntity profissionalEntity = new ProfissionalEntity();
		BeanUtils.copyProperties(profissional, profissionalEntity);

		/* Setando o cargo */
		if (profissional.getCargo() != null) {
			CargoEntity cargoEntity = new CargoEntity();
			BeanUtils.copyProperties(profissional.getCargo(), cargoEntity);
			profissionalEntity.setCargo(cargoEntity);
		}

		/* Setando a especialidade */
		if (profissional.getEspecialidade() != null) {
			EspecialidadeEntity especialidadeEntity = new EspecialidadeEntity();
			BeanUtils.copyProperties(profissional.getEspecialidade(),
					especialidadeEntity);
			profissionalEntity.setEspecialidade(especialidadeEntity);
		}

		/* Setando o status */
		if (profissional.getStatus() != null) {
			StatusEntity statusEntity = new StatusEntity();
			BeanUtils.copyProperties(profissional.getStatus(), statusEntity);
			profissionalEntity.setStatus(statusEntity);
		}

		repository.save(profissionalEntity);
		profissional.setId(profissionalEntity.getId());
		return profissional;
	}

	@Override
	public Profissional consultar(Integer id) {
		Profissional profissional = new Profissional();
		ProfissionalEntity profissionalEntity = repository.findOne(id);
		BeanUtils.copyProperties(profissionalEntity, profissional);

		/* Setando o cargo */
		Cargo cargo = new Cargo();
		BeanUtils.copyProperties(profissionalEntity.getCargo(), cargo);
		profissional.setCargo(cargo);

		/* Setando a especialidade */
		Especialidade especialidade = new Especialidade();
		BeanUtils.copyProperties(profissionalEntity.getEspecialidade(),
				especialidade);
		profissional.setEspecialidade(especialidade);

		/* Setando o status */
		Status status = new Status();
		BeanUtils.copyProperties(profissionalEntity.getStatus(), status);
		profissional.setStatus(status);

		return profissional;
	}

	@Override
	public void excluir(Integer id) {
		repository.delete(id);
	}

	@Override
	public List<Profissional> listarTodos() {
		List<Profissional> listaProfissional = new ArrayList<Profissional>();
		List<ProfissionalEntity> listaProfissionalEntities = repository
				.findAll();

		for (ProfissionalEntity profissionalEntity : listaProfissionalEntities) {
			Profissional profissional = new Profissional();
			BeanUtils.copyProperties(profissionalEntity, profissional);

			/* Setando o cargo */
			if (profissionalEntity.getStatus() != null) {
				Cargo cargo = new Cargo();
				BeanUtils.copyProperties(profissionalEntity.getCargo(), cargo);
				profissional.setCargo(cargo);
			}

			/* Setando a especialidade */
			if (profissionalEntity.getStatus() != null) {
				Especialidade especialidade = new Especialidade();
				BeanUtils.copyProperties(profissionalEntity.getEspecialidade(),
						especialidade);
				profissional.setEspecialidade(especialidade);
			}

			/* Setando o status da Profissional */
			if (profissionalEntity.getStatus() != null) {
				Status status = new Status();
				BeanUtils
						.copyProperties(profissionalEntity.getStatus(), status);
				profissional.setStatus(status);
			}

			listaProfissional.add(profissional);
		}

		return listaProfissional;
	}

	@Override
	public List<Profissional> listarTodosCombo() {
		List<Profissional> listaProfissional = new ArrayList<Profissional>();
		List<ProfissionalEntity> listaProfissionalEntities = repository.list();

		for (ProfissionalEntity ProfissionalEntity : listaProfissionalEntities) {
			Profissional Profissional = new Profissional();
			BeanUtils.copyProperties(ProfissionalEntity, Profissional);

			/* Setando o status da Profissional */
			Status status = new Status();
			if (ProfissionalEntity.getStatus() != null) {
				BeanUtils
						.copyProperties(ProfissionalEntity.getStatus(), status);
				Profissional.setStatus(status);
			}

			listaProfissional.add(Profissional);
		}

		return listaProfissional;
	}
}
