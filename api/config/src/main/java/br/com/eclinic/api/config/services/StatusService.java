package br.com.eclinic.api.config.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.eclinic.domain.config.Status;
import br.com.eclinic.infrastructure.config.business.interfaces.IStatusBusiness;

@RestController
@RequestMapping("/api/status")
public class StatusService {

	@Autowired
	private IStatusBusiness statusBusiness;

	// Ex: http://localhost:8080/api/status/gravar/{status}
	@RequestMapping(value = "/gravar", method = RequestMethod.POST)
	public ResponseEntity<Status> gravar(@RequestBody Status status) {
		status = statusBusiness.gravar(status);
		return new ResponseEntity<Status>(status, HttpStatus.OK);
	}

	@RequestMapping(value = "/consultar", method = RequestMethod.GET)
	public ResponseEntity<Status> consultar(@PathVariable("id") Integer id) {
		Status status = statusBusiness.consultar(id);
		return new ResponseEntity<Status>(status, HttpStatus.OK);
	}

	@RequestMapping(value = "/excluir", method = RequestMethod.DELETE)
	public ResponseEntity<String> excluir(@PathVariable("id") Integer id) {
		statusBusiness.excluir(id);
		return new ResponseEntity<String>("{'status': 'OK'}", HttpStatus.OK);
	}

	@RequestMapping(value = "/listarTodos", method = RequestMethod.GET)
	public ResponseEntity<List<Status>> listarTodos() {
		List<Status> listaStatus = statusBusiness.listarTodos();
		return new ResponseEntity<List<Status>>(listaStatus, HttpStatus.OK);
	}

}