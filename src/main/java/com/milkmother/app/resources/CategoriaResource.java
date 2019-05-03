package com.milkmother.app.resources;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.milkmother.app.domain.Categoria;
import com.milkmother.app.domain.Endereco;
import com.milkmother.app.services.CategoriaService;

//Controlador Rest os métodos geralmente são pequenos
@RestController
@RequestMapping(value="/categorias")
public class CategoriaResource {
	
	@Autowired
	private CategoriaService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Categoria obj = service.buscar(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping(value="/getCep/{cep}")
	  public ResponseEntity<Endereco> doObterCep(@PathVariable(name = "cep") String cep) {
	    //
	    /**
	     * Criando e instanciando um objeto do tipo RestTemplate, este objeto possui métodos que
	     * irá permitir a comunicação com o webservice
	     */
	    RestTemplate restTemplate = new RestTemplate();
	    
	    String uri = "http://viacep.com.br/ws/{cep}/json/";
	    
	    Map<String, String> params = new HashMap<String, String>();
	    params.put("cep", cep);
	    
	    Endereco endereco = restTemplate.getForObject(uri, Endereco.class, params);
	    /**
	     * ResponseEntity permite retornar para tela os dados encontratos, o primeiro parametro recebe os dados, o segundo o status do response. 
	     */
	    return new ResponseEntity<Endereco>(endereco, HttpStatus.OK);
	  }
	}
