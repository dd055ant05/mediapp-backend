package com.mitocode.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mitocode.model.SignoVital;
import com.mitocode.repo.IGenericRepo;
import com.mitocode.repo.ISignoVitalRepo;
import com.mitocode.service.ISignoVitalService;

@Service
public class SignoVitalServiceImpl extends GenericServiceImpl<SignoVital, Integer> implements ISignoVitalService {

	@Autowired
	private ISignoVitalRepo repo;

	@Override
	protected IGenericRepo<SignoVital, Integer> getRepo() {
		return repo;
	}

	@Override
	public Page<SignoVital> listarPageable(Pageable pageable) {
		return repo.findAll(pageable);
	}

}
