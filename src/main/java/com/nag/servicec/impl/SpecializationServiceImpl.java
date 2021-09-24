package com.nag.servicec.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nag.entity.Specialization;
import com.nag.repo.SpecializationRepository;
import com.nag.service.ISpecializationService;


@Service
public class SpecializationServiceImpl implements ISpecializationService {
	
	@Autowired
	private SpecializationRepository repo;

	@Override
	public Long saveSpecialization(Specialization spec) {
		return repo.save(spec).getId();
	}

	@Override
	public List<Specialization> getAllSpecializations() {
	
		return repo.findAll();
	}

	@Override
	public void removeSpecialization(Long id) {
		repo.deleteById(id);
   }

	@Override
	public Specialization getOneSpecialization(Long id) {
		
		return repo.getById(id);
	}

	@Override
	public void updateSpecialization(Specialization spec) {
		repo.save(spec);

	}

}
