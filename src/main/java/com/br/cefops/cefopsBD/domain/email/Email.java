package com.br.cefops.cefopsBD.domain.email;

import java.io.IOException;
import java.util.Map;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class Email  implements  EmailService {
	@Autowired
    private JavaMailSender emailSender;
	
	  public void sendSimpleMessage(String to, String subject, String text) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("noreply@cefops.net");
            message.setTo("ti.4@gmail.com");
            message.setSubject("sdf");
            message.setText("oi testando sa bosta");

            emailSender.send(message);
        } catch (MailException exception) {
            exception.printStackTrace();
        }
    }
	@Override
	public void sendSimpleMessageUsingTemplate(String to, String subject, String... templateModel) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sendMessageWithAttachment(String to, String subject, String text, String pathToAttachment) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sendMessageUsingThymeleafTemplate(String to, String subject, Map<String, Object> templateModel)
			throws IOException, MessagingException {
		// TODO Auto-generated method stub
		
	}
}
