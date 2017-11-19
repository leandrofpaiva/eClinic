package br.com.eclinic.infrastructure.cep.business;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.eclinic.infrastructure.cep.business.interfaces.ICidadeBusiness;
import br.com.eclinic.infrastructure.cep.entities.CidadeEntity;
import br.com.eclinic.infrastructure.cep.repositories.CidadeRepository;

/**
 * Classe de Servico - CidadesBusiness
 * 
 * @author javadev
 */
@Component
public class CidadeBusiness implements ICidadeBusiness {

    /**
     * Entity Manager
     */
    @PersistenceContext
    private EntityManager em;

    /**
     * Repository
     */
    @Autowired
    private CidadeRepository repository;

    @Override
    public CidadeEntity create(CidadeEntity cidades) {
        return repository.save(cidades);
    }

    @Override
    public CidadeEntity read(Integer id) {
        return repository.findOne(id);
    }

    @Override
    public CidadeEntity update(CidadeEntity cidades) {
        return repository.save(cidades);
    }

    @Override
    public void delete(Integer id) {
        repository.delete(id);
    }

    @Override
    public List<CidadeEntity> list() {
        return repository.findAll();
    }

}
