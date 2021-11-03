package com.br.cefops.cefopsBD.domain.email;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.cefops.cefopsBD.repository.Seguranca.UserRepository;
import com.br.cefops.cefopsBD.repository.Seguranca.passwordTokenRepository;

@RestController
@RequestMapping("/api/v1/mail/")
public class Emailcontrol {
	SendMailService service;

    public Emailcontrol(SendMailService service) {
        this.service = service;
    }

	@Autowired
	passwordTokenRepository tokenRepository;
	 @Autowired
	  JavaMailSender mailSender;
	 @Autowired 
	 MessageSource messages;
	 @Autowired
	 UserRepository userService;

    @PostMapping("/send")
    public ResponseEntity<String> sendMail(@RequestBody Mail mail) {
   
        service.sendMail(mail);
        return new ResponseEntity<>("Email Sent successfully", HttpStatus.OK);
    }

    @PostMapping("/attachment")
    public ResponseEntity<String> sendAttachmentEmail(@RequestBody Mail mail) throws MessagingException {
        service.sendMailWithAttachments(mail);
        return new ResponseEntity<>("Attachment mail sent successfully", HttpStatus.OK);
    }
   
}
