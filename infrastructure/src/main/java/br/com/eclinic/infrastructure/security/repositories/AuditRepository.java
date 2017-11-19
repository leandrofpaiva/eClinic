package br.com.eclinic.infrastructure.security.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.eclinic.infrastructure.security.entities.AuditEntity;

/**
 * @author javadev
 * 
 */
public interface AuditRepository extends JpaRepository<AuditEntity, Integer>
{

	List<AuditEntity> findByPostedById(int userId);

}
