package br.com.eclinic.api.nfe.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.eclinic.domain.cep.Endereco;
import br.com.eclinic.domain.types.Cep;
import br.com.eclinic.infrastructure.cep.business.interfaces.IEnderecoBusiness;

@RestController
@RequestMapping("/api/nfe")
public class NFEService {

	@Autowired
	private IEnderecoBusiness enderecoBusiness;

	// Ex: http://localhost:8080/api/cep/findAddressByCep/37550-000
	@RequestMapping(value = "/findAddressByCep/{cep}", method = RequestMethod.GET)
	public ResponseEntity<Endereco> findAddressByCep(@PathVariable("cep") String cep) {
		System.out.println("CEP: " + cep);
		System.out.println("CEP: " + Cep.fromString(cep));
		Endereco endereco = enderecoBusiness.findByCep(Cep.fromString(cep));

		return new ResponseEntity<Endereco>(endereco, HttpStatus.OK);
	}

}