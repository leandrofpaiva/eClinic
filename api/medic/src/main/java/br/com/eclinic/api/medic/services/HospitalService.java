package br.com.eclinic.api.medic.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.eclinic.domain.medic.Hospital;
import br.com.eclinic.infrastructure.medic.business.interfaces.IHospitalBusiness;

@RestController
@RequestMapping("/api/hospital")
public class HospitalService {

	@Autowired
	private IHospitalBusiness hospitalBusiness;

	// Ex: http://localhost:8080/api/hospital/gravar/{hospital}
	@RequestMapping(value = "/gravar", method = RequestMethod.POST)
	public ResponseEntity<Hospital> gravar(@RequestBody Hospital hospital) {
		hospital = hospitalBusiness.gravar(hospital);
		return new ResponseEntity<Hospital>(hospital, HttpStatus.OK);
	}

	@RequestMapping(value = "/consultar", method = RequestMethod.GET)
	public ResponseEntity<Hospital> consultar(@PathVariable("id") Integer id) {
		Hospital hospital = hospitalBusiness.consultar(id);
		return new ResponseEntity<Hospital>(hospital, HttpStatus.OK);
	}

	@RequestMapping(value = "/excluir", method = RequestMethod.DELETE)
	public ResponseEntity<String> excluir(@PathVariable("id") Integer id) {
		hospitalBusiness.excluir(id);
		return new ResponseEntity<String>("{'status': 'OK'}", HttpStatus.OK);
	}

	@RequestMapping(value = "/listarTodos", method = RequestMethod.GET)
	public ResponseEntity<List<Hospital>> listarTodos() {
		List<Hospital> listaHospitals = hospitalBusiness.listarTodos();
		return new ResponseEntity<List<Hospital>>(listaHospitals, HttpStatus.OK);
	}

	@RequestMapping(value = "/listarTodosCombo", method = RequestMethod.GET)
	public ResponseEntity<List<Hospital>> listarTodosCombo() {
		List<Hospital> listaHospitals = hospitalBusiness.listarTodosCombo();
		return new ResponseEntity<List<Hospital>>(listaHospitals, HttpStatus.OK);
	}
}