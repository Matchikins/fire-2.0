package com.br.cefops.cefopsBD.domain.email;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;


import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class Email  implements  SendMailService {
	@Autowired
 JavaMailSender javaMailSender;

	    public Email(JavaMailSender javaMailSender) {
	        this.javaMailSender = javaMailSender;
	    }

	    @Override
	    public void sendMail(Mail mail) {
	        SimpleMailMessage msg = new SimpleMailMessage();
	        msg.setTo(mail.getRecipient(), mail.getRecipient());
	        msg.setFrom("noreplay@cefops.com.br");
	        msg.setSubject(mail.getSubject());
	        msg.setText(mail.getMessage());

	        javaMailSender.send(msg);
	    }
	    

	    @Override
	    public void sendMailWithAttachments(Mail mail) throws MessagingException {
	        MimeMessage msg = javaMailSender.createMimeMessage();

	        MimeMessageHelper helper = new MimeMessageHelper(msg, true);

	        helper.setTo("ti4.eas@gmail.com");
	        helper.setFrom("noreplay@cefops.com.br");
	        helper.setSubject("Testing from Spring Boot");

	        helper.setText("Find the attached image", true);

	        helper.addAttachment("ce.png", new ClassPathResource("C:\\Users\\e.dias\\Documents\\projeto cefops\\fire-2.0-main\\ce.png"));

	        javaMailSender.send(msg);
	    }

		@Override
		public void sendMailReset(String email, String assunto, String bodString) throws MessagingException {
			// TODO Auto-generated method stub
			
		}
}
