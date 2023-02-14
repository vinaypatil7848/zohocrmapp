package com.marketing.service;

import java.util.List;

import com.marketing.entities.Lead;

public interface LeadService {

	void saveInfo(Lead lead);

	List<Lead> listLeads();

	void delete(Long id);

	Lead getLeadInfo(Long id);



}
