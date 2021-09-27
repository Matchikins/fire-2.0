package com.br.cefops.cefopsBD.domain.email;

import javax.mail.MessagingException;

public interface SendMailService {


	    void sendMail(Mail mail);

	    void sendMailWithAttachments(Mail mail) throws MessagingException;

		void sendMailReset(String email, String assunto, String bodString) throws MessagingException;


}
