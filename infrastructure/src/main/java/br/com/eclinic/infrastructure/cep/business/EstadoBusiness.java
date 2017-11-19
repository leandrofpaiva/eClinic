package br.com.eclinic.infrastructure.cep.business;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.eclinic.infrastructure.cep.business.interfaces.IEstadoBusiness;
import br.com.eclinic.infrastructure.cep.entities.EstadoEntity;
import br.com.eclinic.infrastructure.cep.repositories.EstadoRepository;

/**
 * Classe de Servico - estadoBusiness
 * 
 * @author javadev
 */
@Component
public class EstadoBusiness implements IEstadoBusiness {

    /**
     * Entity Manager
     */
    @PersistenceContext
    private EntityManager em;

    /**
     * Repository
     */
    @Autowired
    private EstadoRepository repository;

    @Override
    public EstadoEntity create(EstadoEntity estado) {
        return repository.save(estado);
    }

    @Override
    public EstadoEntity read(Integer id) {
        return repository.findOne(id);
    }

    @Override
    public EstadoEntity update(EstadoEntity estado) {
        return repository.save(estado);
    }

    @Override
    public void delete(Integer id) {
        repository.delete(id);
    }

    @Override
    public List<EstadoEntity> list() {
        return repository.findAll();
    }

}
