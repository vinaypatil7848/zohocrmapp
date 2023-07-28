package com.marketing.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.marketing.dto.LeadData;
import com.marketing.entities.Lead;
import com.marketing.service.LeadService;
import com.marketing.util.EmailService;

@Controller
public class LeadController {
	
	@Autowired
	private LeadService leadservice;
	
	@Autowired
	private EmailService emailservice;

	//http://localhost:8080/create
	@RequestMapping("/create")
	public String createView() {
		return "create_lead";
	}

	@RequestMapping("/create")
	public String createView() {
		return "create_lead";
	}

	@RequestMapping("/create")
	public String createView() {
		return "create_lead";
	}
	
	@RequestMapping("/saveLead")
	public String saveLead(@ModelAttribute("l") Lead lead,Model model) {
		leadservice.saveInfo(lead);
		emailservice.sendEmail(lead.getEmail(), "welcome to psa", "Test email from the spring boot");
		model.addAttribute("msg", "data saved!!");
		return "create_lead";
	}
	
//	@RequestMapping("/saveLead")
//	public String createLead(@RequestParam("firstName")String firstName,@RequestParam("lastName")String lastName,@RequestParam("email")String email,@RequestParam("mobile")String mobile,Model model) {
//		Lead lead=new Lead();
//		lead.setFirstName(firstName);
//		lead.setLastName(lastName);
//		lead.setEmail(email);
//		lead.setMobile(mobile);
//		
//		leadservice.saveInfo(lead);
//		model.addAttribute("msg", "data saved!!");
//		return "create_lead";
//	}
	
//	@RequestMapping("/saveLead")
//	public String createLead(LeadData leadData,Model model) {
//		Lead lead=new Lead();
//		lead.setFirstName(leadData.getFirstName());
//		lead.setLastName(leadData.getLastName());
//		lead.setEmail(leadData.getEmail());
//		lead.setMobile(leadData.getMobile());
//		leadservice.saveInfo(lead);
//		
//		model.addAttribute("msg", "data saved!!");
//		return "create_lead";
//		
//	}
	
	//http://localhost:8080/listAll
	@RequestMapping("/listAll")
	public String listAll(Model model) {
		List<Lead> leads = leadservice.listLeads();
		model.addAttribute("leads", leads);
		System.out.println(leads);
		return "list_all";
	}
	
	@RequestMapping("delete")
	public String delete(@RequestParam("id")Long id,Model model) {
		Lead lead=new Lead();
		lead.setId(id);
		leadservice.delete(id);
		
		List<Lead> leads = leadservice.listLeads();
		model.addAttribute("leads", leads);
		System.out.println(leads);
		return "list_all";
	}
	
	@RequestMapping("/update")
	public String getLead(@RequestParam("id")Long id,Model model) {
		Lead lead = leadservice.getLeadInfo(id);
		model.addAttribute("lead", lead);
		return "update_lead";
	}
	
	@RequestMapping("/updateLead")
	public String updateLead(@ModelAttribute("l")Lead lead,Model model) {
		leadservice.saveInfo(lead);
		
		List<Lead> leads = leadservice.listLeads();
		model.addAttribute("leads", leads);
		return "list_all";
	}
	
	
	
}
