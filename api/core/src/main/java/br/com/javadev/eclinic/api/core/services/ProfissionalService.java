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

import br.com.javadev.eclinic.domain.core.Profissional;
import br.com.javadev.eclinic.infrastructure.core.business.interfaces.IProfissionalBusiness;

@RestController
@RequestMapping("/api/profissional")
public class ProfissionalService {

	@Autowired
	private IProfissionalBusiness profissionalBusiness;

	// Ex: http://localhost:8080/api/profissional/gravar/{profissional}
	@RequestMapping(value = "/gravar", method = RequestMethod.POST)
	public ResponseEntity<Profissional> gravar(@RequestBody Profissional profissional) {
		profissional = profissionalBusiness.gravar(profissional);
		return new ResponseEntity<Profissional>(profissional, HttpStatus.OK);
	}

	@RequestMapping(value = "/consultar", method = RequestMethod.GET)
	public ResponseEntity<Profissional> consultar(@PathVariable("id") Integer id) {
		Profissional profissional = profissionalBusiness.consultar(id);
		return new ResponseEntity<Profissional>(profissional, HttpStatus.OK);
	}

	@RequestMapping(value = "/excluir", method = RequestMethod.DELETE)
	public ResponseEntity<String> excluir(@PathVariable("id") Integer id) {
		profissionalBusiness.excluir(id);
		return new ResponseEntity<String>("{'status': 'OK'}", HttpStatus.OK);
	}

	@RequestMapping(value = "/listarTodos", method = RequestMethod.GET)
	public ResponseEntity<List<Profissional>> listarTodos() {
		List<Profissional> listaProfissionals = profissionalBusiness.listarTodos();
		return new ResponseEntity<List<Profissional>>(listaProfissionals, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/listarTodosCombo", method = RequestMethod.GET)
	public ResponseEntity<List<Profissional>> listarTodosCombo() {
		List<Profissional> listaProfissionals = profissionalBusiness.listarTodosCombo();
		return new ResponseEntity<List<Profissional>>(listaProfissionals, HttpStatus.OK);
	}

}