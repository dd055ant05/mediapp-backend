package com.mitocode.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mitocode.model.SignoVital;

public interface ISignoVitalService extends IGenericService<SignoVital, Integer>{
	
	Page<SignoVital> listarPageable(Pageable pageable);
	
}
