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

import br.com.javadev.eclinic.domain.core.Especialidade;
import br.com.javadev.eclinic.infrastructure.core.business.interfaces.IEspecialidadeBusiness;

@RestController
@RequestMapping("/api/especialidade")
public class EspecialidadeService {

	@Autowired
	private IEspecialidadeBusiness especialidadeBusiness;

	// Ex: http://localhost:8080/api/especialidade/gravar/{especialidade}
	@RequestMapping(value = "/gravar", method = RequestMethod.POST)
	public ResponseEntity<Especialidade> gravar(@RequestBody Especialidade especialidade) {
		especialidade = especialidadeBusiness.gravar(especialidade);
		return new ResponseEntity<Especialidade>(especialidade, HttpStatus.OK);
	}

	@RequestMapping(value = "/consultar", method = RequestMethod.GET)
	public ResponseEntity<Especialidade> consultar(@PathVariable("id") Integer id) {
		Especialidade especialidade = especialidadeBusiness.consultar(id);
		return new ResponseEntity<Especialidade>(especialidade, HttpStatus.OK);
	}

	@RequestMapping(value = "/excluir", method = RequestMethod.DELETE)
	public ResponseEntity<String> excluir(@PathVariable("id") Integer id) {
		especialidadeBusiness.excluir(id);
		return new ResponseEntity<String>("{'status': 'OK'}", HttpStatus.OK);
	}

	@RequestMapping(value = "/listarTodos", method = RequestMethod.GET)
	public ResponseEntity<List<Especialidade>> listarTodos() {
		List<Especialidade> listaEspecialidades = especialidadeBusiness.listarTodos();
		return new ResponseEntity<List<Especialidade>>(listaEspecialidades, HttpStatus.OK);
	}

	@RequestMapping(value = "/listarTodosCombo", method = RequestMethod.GET)
	public ResponseEntity<List<Especialidade>> listarTodosCombo() {
		List<Especialidade> listaEspecialidades = especialidadeBusiness.listarTodosCombo();
		return new ResponseEntity<List<Especialidade>>(listaEspecialidades, HttpStatus.OK);
	}
}