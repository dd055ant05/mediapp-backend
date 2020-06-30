package com.mitocode.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mitocode.model.ConsultaExamen;
import com.mitocode.service.IConsultaExamenService;

@RestController
@RequestMapping("/consultaexamenes")
public class ConsultaExamenController {

	@Autowired
	private IConsultaExamenService service;

	@GetMapping(value = "/{idConsulta}")
	public ResponseEntity<List<ConsultaExamen>> listar(@PathVariable("idConsulta") Integer idConsulta) {
		List<ConsultaExamen> consultaExamen = new ArrayList<>();
		consultaExamen = service.listarExamenesPorConsulta(idConsulta);
		return new ResponseEntity<List<ConsultaExamen>>(consultaExamen, HttpStatus.OK);
	}

}
