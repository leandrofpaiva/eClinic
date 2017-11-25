package br.com.javadev.eclinic.api.core.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.javadev.eclinic.domain.core.Cargo;
import br.com.javadev.eclinic.infrastructure.core.business.interfaces.ICargoBusiness;

@RestController
@RequestMapping("/api/cargo")
public class CargoService {

	@Autowired
	private ICargoBusiness cargoBusiness;

	// Ex: http://localhost:8080/api/cargo/gravar/{cargo}
	@RequestMapping(value = "/gravar", method = RequestMethod.POST)
	public ResponseEntity<Cargo> gravar(@RequestBody Cargo cargo) {
		cargo = cargoBusiness.gravar(cargo);
		return new ResponseEntity<Cargo>(cargo, HttpStatus.OK);
	}

	@RequestMapping(value = "/consultar", method = RequestMethod.GET)
	public ResponseEntity<Cargo> consultar(@PathVariable("id") Integer id) {
		Cargo cargo = cargoBusiness.consultar(id);
		return new ResponseEntity<Cargo>(cargo, HttpStatus.OK);
	}

	@RequestMapping(value = "/excluir", method = RequestMethod.DELETE)
	public ResponseEntity<String> excluir(@PathVariable("id") Integer id) {
		cargoBusiness.excluir(id);
		return new ResponseEntity<String>("{'status': 'OK'}", HttpStatus.OK);
	}

	@RequestMapping(value = "/listarTodos", method = RequestMethod.GET)
	public ResponseEntity<List<Cargo>> listarTodos() {
		List<Cargo> listaCargo = cargoBusiness.listarTodos();
		return new ResponseEntity<List<Cargo>>(listaCargo, HttpStatus.OK);
	}

	@RequestMapping(value = "/listarTodosCombo", method = RequestMethod.GET)
	public ResponseEntity<List<Cargo>> listarTodosCombo() {
		List<Cargo> listaCargo = cargoBusiness.listarTodosCombo();
		return new ResponseEntity<List<Cargo>>(listaCargo, HttpStatus.OK);
	}
}