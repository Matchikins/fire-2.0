//package com.br.cefops.cefopsBD.Controller;
//
//import java.util.Locale;
//import java.util.UUID;
//
//import javax.servlet.http.HttpServletRequest;
//
//import org.aspectj.weaver.ast.Var;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.MessageSource;
//import org.springframework.http.MediaType;
//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.br.cefops.cefopsBD.domain.seguranca.User;
//import com.br.cefops.cefopsBD.domain.Financias.GenericResponse;
//import com.br.cefops.cefopsBD.domain.Financias.PasswordResetToken;
//import com.br.cefops.cefopsBD.domain.email.Email;
//import com.br.cefops.cefopsBD.domain.email.Mail;
//import com.br.cefops.cefopsBD.domain.email.ResetpasswordEmail;
//import com.br.cefops.cefopsBD.repository.Seguranca.UserRepository;
//import com.br.cefops.cefopsBD.repository.Seguranca.passwordTokenRepository;
//
//@RestController
//public class userResetPassword {
//    private final Logger LOGGER = LoggerFactory.getLogger(getClass());
//@Autowired
//    userResetPassword service;
//
//
//
//	
//	@Autowired
//	passwordTokenRepository tokenRepository;
//	 @Autowired
//	  JavaMailSender mailSender;
//	 @Autowired 
//	 MessageSource messages;
//	 @Autowired
//	 UserRepository userService;
//	
//	@PostMapping(path = "/user/resetPassword")
//	public GenericResponse resetPassword(HttpServletRequest request, 
//	  @RequestParam("email") String userEmail) {
//	    User user = userService.findUserByEmail(userEmail);
//	    if (user == null) {
//	        throw new UsernameNotFoundException("Username  not found!");
//	    }
//		    String token = UUID.randomUUID().toString();
//		    createPasswordResetTokenForUser(user, token);
//	    mailSender.send(constructResetTokenEmail(getAppUrl(request), 
//	      request.getLocale(), token, user));
//	  
//	    
//	      messages.getMessage("message.resetPasswordEmail", null, 
//	      request.getLocale());
//	      ResetpasswordEmail emaillEmail2=new ResetpasswordEmail();
//	      emaillEmail2.sendMailReset(user.getEmail(), "Redefinir Senha", token);
//		return null;
//	}
//	public void createPasswordResetTokenForUser(User user, String token) {
//	    PasswordResetToken myToken = new PasswordResetToken(token, user);
//	    tokenRepository.save(myToken);
//	}
//	
//	private SimpleMailMessage constructResetTokenEmail(
//			String contextPath, Locale locale, String token, User user) {
//		
//			    String url = contextPath + "/user/changePassword?token=" + token;
//			    String message = messages.getMessage("message.resetPassword", 
//			      null,locale );
//			    
//			    return null;
//			}
//
//			private SimpleMailMessage constructEmail(String subject, String body, 
//			  User user) {
//			    SimpleMailMessage email = new SimpleMailMessage();
//			    email.setSubject(subject);
//			    email.setText(body);
//			    email.setTo(user.getEmail());
//			    email.setFrom("roreplay@Cefops.com.br");
//			    mailSender.send(email);
//			    System.out.println(MediaType.ALL_VALUE);
//			    Mail testeMail=new Mail();
//			    testeMail.setMessage(body);
//			    testeMail.setRecipient(user.getEmail());
//			    testeMail.setSubject(subject);
//			    
//			    return email;
//			}
//			   private String getAppUrl(HttpServletRequest request) {
//			        return "http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
//			    }
//
//}
