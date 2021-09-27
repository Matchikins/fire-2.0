//package com.br.cefops.cefopsBD.domain.email;
//
//import javax.mail.MessagingException;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSender;
//
//public class ResetpasswordEmail  implements  SendMailService {
//	@Autowired
// JavaMailSender javaMailSender;
//
//
//	@Override
//    public void sendMailReset(String email, String assunto,String bodString) {
//		
//        SimpleMailMessage msg = new SimpleMailMessage();
//        msg.setTo(email,email);
//        msg.setFrom("noreplay@cefops.net");
//        msg.setSubject(assunto);
//        msg.setText(bodString);
//
//        javaMailSender.send(msg);
//    }
//	@Override
//	public void sendMailWithAttachments(Mail mail) throws MessagingException {
//		// TODO Auto-generated method stub
//		
//	}
//	@Override
//	public void sendMail(Mail mail) {
//		// TODO Auto-generated method stub
//		
//	}
//}
