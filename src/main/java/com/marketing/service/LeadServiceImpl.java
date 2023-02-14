package com.marketing.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marketing.entities.Lead;
import com.marketing.repositories.LeadRepository;

@Service
public class LeadServiceImpl implements LeadService {
	
	@Autowired
	private LeadRepository leadRepo;

	@Override
	public void saveInfo(Lead lead) {
		leadRepo.save(lead);
	}

	@Override
	public List<Lead> listLeads() {
		List<Lead> leads = leadRepo.findAll();
		return leads;
	}

	@Override
	public void delete(Long id) {
		leadRepo.deleteById(id);
	}

	@Override
	public Lead getLeadInfo(Long id) {
			Optional<Lead> findById = leadRepo.findById(id);
			Lead lead = findById.get();
			return lead;
	}

}
