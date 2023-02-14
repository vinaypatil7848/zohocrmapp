package com.marketing.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;//stereotype means now the class is special class everything related to object function like creation,delete
												//everything is done by the spring boot
@Component
public class EmailServiceImpl implements EmailService {

	@Autowired
	JavaMailSender mailsender;
	
	@Override
	public void sendEmail(String to, String subject, String message) {
		 SimpleMailMessage mailMessage= new SimpleMailMessage();
		 mailMessage.setTo(to);
		 mailMessage.setSubject(subject);
		 mailMessage.setText(message);
		 
		 mailsender.send(mailMessage);
	}

}
