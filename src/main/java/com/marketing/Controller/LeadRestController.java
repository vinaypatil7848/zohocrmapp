package com.marketing.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marketing.entities.Lead;
import com.marketing.repositories.LeadRepository;

@RestController
@RequestMapping("/api/leads")
//http://localhost:8080/api/leads
public class LeadRestController {
	
	@Autowired
	private LeadRepository leadRepo;

	//http://localhost:8080/api/leads
	@GetMapping
	public List<Lead> getAllLeads(){				//read
		List<Lead> lead = leadRepo.findAll();
		return lead;
	}
	
	//http://localhost:8080/api/leads						//@RequestBody will convert JSON object to java object
	@PostMapping
	public void saveOneLead(@RequestBody Lead lead) {		//save
//		System.out.println(lead.getFirstName());
//		System.out.println(lead.getId());
		leadRepo.save(lead);
	}
	
	@PutMapping
	public void updateOneLead(@RequestBody Lead lead) {			//update
		leadRepo.save(lead);
	}
	
	//http://localhost:8080/api/leads/delete/10
	@DeleteMapping("/delete/{id}")								//delete
	public void deleteOneLead(@PathVariable("id") long id) {	// It is used to extract the values from the URI. It is most suitable for the RESTful web service, 
		leadRepo.deleteById(id);								//where the URL contains a path variable
	}
	
	//http://localhost:8080/api/leads/getLead/1
	@RequestMapping("/getLead/{id}")
	public Lead getLead(@PathVariable("id") long id) {
		try {
			Optional<Lead> findById = leadRepo.findById(id);
			Lead lead = findById.get();
			return lead;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
