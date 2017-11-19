package br.com.eclinic.infrastructure.medic.business;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.eclinic.domain.config.Status;
import br.com.eclinic.domain.medic.Especialidade;
import br.com.eclinic.infrastructure.config.entities.StatusEntity;
import br.com.eclinic.infrastructure.medic.business.interfaces.IEspecialidadeBusiness;
import br.com.eclinic.infrastructure.medic.entities.EspecialidadeEntity;
import br.com.eclinic.infrastructure.medic.repositories.EspecialidadeRepository;

/**
 * Classe Business - EspecialidadeBusiness
 * 
 * @author javadev
 */
@Component
public class EspecialidadeBusiness implements IEspecialidadeBusiness {

	/**
	 * Entity Manager
	 */
	@PersistenceContext
	private EntityManager em;

	/**
	 * Repository
	 */
	@Autowired
	private EspecialidadeRepository repository;

	@Override
	public Especialidade gravar(Especialidade Especialidade) {
		EspecialidadeEntity EspecialidadeEntity = new EspecialidadeEntity();
		BeanUtils.copyProperties(Especialidade, EspecialidadeEntity);

		/* Setando o status */
		if (Especialidade.getStatus() != null) {
			StatusEntity statusEntity = new StatusEntity();
			BeanUtils.copyProperties(Especialidade.getStatus(), statusEntity);
			EspecialidadeEntity.setStatus(statusEntity);
		}

		repository.save(EspecialidadeEntity);
		Especialidade.setId(EspecialidadeEntity.getId());
		return Especialidade;
	}

	@Override
	public Especialidade consultar(Integer id) {
		Especialidade Especialidade = new Especialidade();
		EspecialidadeEntity EspecialidadeEntity = repository.findOne(id);
		BeanUtils.copyProperties(EspecialidadeEntity, Especialidade);

		/* Setando o status */
		Status status = new Status();
		BeanUtils.copyProperties(EspecialidadeEntity.getStatus(), status);
		Especialidade.setStatus(status);

		return Especialidade;
	}

	@Override
	public void excluir(Integer id) {
		repository.delete(id);
	}

	@Override
	public List<Especialidade> listarTodos() {
		List<Especialidade> listaEspecialidade = new ArrayList<Especialidade>();
		List<EspecialidadeEntity> listaEspecialidadeEntities = repository
				.findAll();

		for (EspecialidadeEntity EspecialidadeEntity : listaEspecialidadeEntities) {
			Especialidade Especialidade = new Especialidade();
			BeanUtils.copyProperties(EspecialidadeEntity, Especialidade);

			/* Setando o status da Especialidade */
			Status status = new Status();
			if (EspecialidadeEntity.getStatus() != null) {
				BeanUtils.copyProperties(EspecialidadeEntity.getStatus(),
						status);
				Especialidade.setStatus(status);
			}

			listaEspecialidade.add(Especialidade);
		}

		return listaEspecialidade;
	}

	@Override
	public List<Especialidade> listarTodosCombo() {
		List<Especialidade> listaEspecialidade = new ArrayList<Especialidade>();
		List<EspecialidadeEntity> listaEspecialidadeEntities = repository
				.list();

		for (EspecialidadeEntity EspecialidadeEntity : listaEspecialidadeEntities) {
			Especialidade Especialidade = new Especialidade();
			BeanUtils.copyProperties(EspecialidadeEntity, Especialidade);

			/* Setando o status da Especialidade */
			Status status = new Status();
			if (EspecialidadeEntity.getStatus() != null) {
				BeanUtils.copyProperties(EspecialidadeEntity.getStatus(),
						status);
				Especialidade.setStatus(status);
			}

			listaEspecialidade.add(Especialidade);
		}

		return listaEspecialidade;
	}
}
