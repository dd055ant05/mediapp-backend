package com.mitocode.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mitocode.exception.ModeloNotFoundException;
import com.mitocode.model.SignoVital;
import com.mitocode.service.ISignoVitalService;

@RestController
@RequestMapping("/signosVitales")
public class SignoVitalController {

	@Autowired
	private ISignoVitalService service;

	@GetMapping
	public ResponseEntity<List<SignoVital>> listar() throws Exception {
		List<SignoVital> lista = service.listar();
		return new ResponseEntity<List<SignoVital>>(lista, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<SignoVital> listarPorId(@PathVariable("id") Integer id) throws Exception {
		SignoVital sv = service.listarPorId(id);
		if (sv == null) {
			throw new ModeloNotFoundException("Id no encontrado " + id);
		}
		return new ResponseEntity<SignoVital>(sv, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Object> registrar(@Valid @RequestBody SignoVital signoVital) throws Exception {
		SignoVital sv = service.registrar(signoVital);
		// localhost:8080/signosVitales/5
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(sv.getIdSignoVital()).toUri();
		return ResponseEntity.created(location).build();
	}

	@PutMapping
	public ResponseEntity<SignoVital> modificar(@Valid @RequestBody SignoVital signoVital) throws Exception {
		SignoVital sv = service.modificar(signoVital);
		return new ResponseEntity<SignoVital>(sv, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id) throws Exception {
		SignoVital sv = service.listarPorId(id);
		if (sv == null) {
			throw new ModeloNotFoundException("Id no encontrado " + id);
		}
		service.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}

	@GetMapping("/pageable")
	public ResponseEntity<Page<SignoVital>> listarPageable(Pageable pageable) throws Exception {
		Page<SignoVital> signosVitales = service.listarPageable(pageable);
		return new ResponseEntity<Page<SignoVital>>(signosVitales, HttpStatus.OK);
	}

}
