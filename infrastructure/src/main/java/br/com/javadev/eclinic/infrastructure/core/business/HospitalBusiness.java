package br.com.javadev.eclinic.infrastructure.core.business;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.javadev.eclinic.domain.config.Status;
import br.com.javadev.eclinic.domain.core.Hospital;
import br.com.javadev.eclinic.infrastructure.config.entities.StatusEntity;
import br.com.javadev.eclinic.infrastructure.core.business.interfaces.IHospitalBusiness;
import br.com.javadev.eclinic.infrastructure.core.entities.HospitalEntity;
import br.com.javadev.eclinic.infrastructure.core.repositories.HospitalRepository;

/**
 * Classe Business - HospitalBusiness
 * 
 * @author javadev
 */
@Component
public class HospitalBusiness implements IHospitalBusiness {

	/**
	 * Entity Manager
	 */
	@PersistenceContext
	private EntityManager em;

	/**
	 * Repository
	 */
	@Autowired
	private HospitalRepository repository;

	@Override
	public Hospital gravar(Hospital Hospital) {
		HospitalEntity HospitalEntity = new HospitalEntity();
		BeanUtils.copyProperties(Hospital, HospitalEntity);

		/* Setando o status */
		if (Hospital.getStatus() != null) {
			StatusEntity statusEntity = new StatusEntity();
			BeanUtils.copyProperties(Hospital.getStatus(), statusEntity);
			HospitalEntity.setStatus(statusEntity);
		}

		repository.save(HospitalEntity);
		Hospital.setId(HospitalEntity.getId());
		return Hospital;
	}

	@Override
	public Hospital consultar(Integer id) {
		Hospital Hospital = new Hospital();
		HospitalEntity HospitalEntity = repository.findOne(id);
		BeanUtils.copyProperties(HospitalEntity, Hospital);

		/* Setando o status */
		Status status = new Status();
		BeanUtils.copyProperties(HospitalEntity.getStatus(), status);
		Hospital.setStatus(status);

		return Hospital;
	}

	@Override
	public void excluir(Integer id) {
		repository.delete(id);
	}

	@Override
	public List<Hospital> listarTodos() {
		List<Hospital> listaHospital = new ArrayList<Hospital>();
		List<HospitalEntity> listaHospitalEntities = repository.findAll();

		for (HospitalEntity HospitalEntity : listaHospitalEntities) {
			Hospital Hospital = new Hospital();
			BeanUtils.copyProperties(HospitalEntity, Hospital);

			/* Setando o status da Hospital */
			Status status = new Status();
			if (HospitalEntity.getStatus() != null) {
				BeanUtils.copyProperties(HospitalEntity.getStatus(), status);
				Hospital.setStatus(status);
			}

			listaHospital.add(Hospital);
		}

		return listaHospital;
	}

	@Override
	public List<Hospital> listarTodosCombo() {
		List<Hospital> listaHospital = new ArrayList<Hospital>();
		List<HospitalEntity> listaHospitalEntities = repository.list();

		for (HospitalEntity HospitalEntity : listaHospitalEntities) {
			Hospital Hospital = new Hospital();
			BeanUtils.copyProperties(HospitalEntity, Hospital);

			/* Setando o status da Hospital */
			Status status = new Status();
			if (HospitalEntity.getStatus() != null) {
				BeanUtils.copyProperties(HospitalEntity.getStatus(), status);
				Hospital.setStatus(status);
			}

			listaHospital.add(Hospital);
		}

		return listaHospital;
	}
}
