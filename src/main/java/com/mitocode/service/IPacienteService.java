package com.mitocode.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mitocode.model.Paciente;

public interface IPacienteService extends IGenericService<Paciente, Integer>{
	
	Page<Paciente> listarPageable(Pageable pageable);
	
}
