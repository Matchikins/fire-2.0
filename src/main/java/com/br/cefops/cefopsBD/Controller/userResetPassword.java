//package com.br.cefops.cefopsBD.Controller;
//
//import java.util.Locale;
//import java.util.UUID;
//
//import javax.servlet.http.HttpServletRequest;
//
//import org.hibernate.cfg.Environment;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.MessageSource;
//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.br.cefops.cefopsBD.domain.User;
//import com.br.cefops.cefopsBD.domain.Model.GenericResponse;
//import com.br.cefops.cefopsBD.domain.Model.PasswordResetToken;
//import com.br.cefops.cefopsBD.repository.IpasswordResetToken;
//import com.br.cefops.cefopsBD.repository.passwordTokenRepository;
//
//@RestController
//public class userResetPassword {
//    private final Logger LOGGER = LoggerFactory.getLogger(getClass());
//
//	
//	
//	
//	@Autowired
//	passwordTokenRepository tokenRepository;
//	 @Autowired
//	  JavaMailSender mailSender;
//	 @Autowired
//	 Environment env;
//	 @Autowired
//	 GenericResponse response1;
//	 @Autowired 
//	 MessageSource messages;
//	
//	@PostMapping("/user/resetPassword")
//	public GenericResponse resetPassword(HttpServletRequest request, 
//	  @RequestParam("email") String userEmail) {
//	    User user = userService.findUserByEmail(userEmail);
//	    if (user == null) {
//	        throw new UsernameNotFoundException("Username  not found!");
//	    }
//	    String token = UUID.randomUUID().toString();
//	    userService.createPasswordResetTokenForUser(user, token);
//	    mailSender.send(constructResetTokenEmail(getAppUrl(request), 
//	      request.getLocale(), token, user));
//	    return new GenericResponse(
//	      messages.getMessage("message.resetPasswordEmail", null, 
//	      request.getLocale()));
//	}
//	public void createPasswordResetTokenForUser(User user, String token) {
//	    PasswordResetToken myToken = new PasswordResetToken(token, user);
//	    tokenRepository.save(myToken);
//	}
//	
//	private SimpleMailMessage constructResetTokenEmail(
//			  String contextPath, Locale locale, String token, User user) {
//			    String url = contextPath + "/user/changePassword?token=" + token;
//			    String message = messages.getMessage("message.resetPassword", 
//			      null, locale);
//			    return constructEmail("Reset Password", message + " \r\n" + url, user);
//			}
//
//			private SimpleMailMessage constructEmail(String subject, String body, 
//			  User user) {
//			    SimpleMailMessage email = new SimpleMailMessage();
//			    email.setSubject(subject);
//			    email.setText(body);
//			    email.setTo(user.getEmail());
//			    email.setFrom("roreplay@Cefops.com.br");
//			    return email;
//			}
//			   private String getAppUrl(HttpServletRequest request) {
//			        return "http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
//			    }
//
//}
