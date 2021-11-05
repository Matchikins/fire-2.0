package com.br.cefops.cefopsBD.Controller.security;

import static org.springframework.http.ResponseEntity.ok;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.br.cefops.cefopsBD.Security.JWT.JwtTokenProvider;
import com.br.cefops.cefopsBD.Services.security.UserServices;
import com.br.cefops.cefopsBD.data.vo.v1.AccountCredentialSignUpVO;
import com.br.cefops.cefopsBD.data.vo.v1.AccountCredentialsVO;
import com.br.cefops.cefopsBD.repository.Seguranca.UserRepository;





@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	JwtTokenProvider tokenProvider;
	
	@Autowired
	UserRepository repository;
	@Autowired
	UserServices serviceUser;



//teste

   
	@SuppressWarnings("rawtypes")
	@PostMapping(value = "/signin", produces = "application/json", 
			consumes =  "application/json" )
	public ResponseEntity signin(@RequestBody AccountCredentialsVO data) {
		System.out.println(data.getUsername());
		try {
			var username = data.getUsername();
			var pasword = data.getPassword();
			
			
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, pasword));
			
			var user = repository.findByUsername(username);
		
			var token = "";
			
			if (user != null) {
				token = tokenProvider.createToken(username, user.getRoles());
			} else {
				throw new UsernameNotFoundException("Username " + username + " not found!");
			}
			var levelacess=user.getRoles();
			var fullNames =user.getFristName()+" "+user.getLastName();
			var aluno=user.getAlunos();
			
			
			Map<Object, Object> model = new HashMap<>();
			if (user.getAlunos()==null){
				model.put("AlunoId", "000");
				model.put("foto","https://i.ibb.co/2YYcwWr/sem-foto.png");
			}else {
				model.put("AlunoId", aluno.getId().toString());
				model.put("foto",aluno.getPhoto());
			}
			model.put("FullName",fullNames);
			model.put("role",levelacess );
			model.put("token", token);
			
		
			return ok(model);
		} catch (AuthenticationException e) {
			throw new BadCredentialsException("Invalid username or password !");
		}
	}
	
	
	@ResponseBody
	@PostMapping(value = "/signup", produces = "application/json", 
			consumes =  "application/json")
	public AccountCredentialSignUpVO signup(@Valid @RequestBody AccountCredentialSignUpVO data) {
		try {
			var user =data.getUsername();
			var email=data.getEmail();
			var password=data.getPassword();
			var fristname=data.getFristName();
			var lastname=data.getLastName();
			BCryptPasswordEncoder bCryptPasswordEncoder= new BCryptPasswordEncoder(13);
			var result =bCryptPasswordEncoder.encode(password);
			if (user.isEmpty()) {
			throw new BadCredentialsException("Erro ao cadastrar !");
		}
			
			serviceUser.saveUser(email, result, user, fristname,lastname);
			
		} catch (AuthenticationException e) {
			throw new BadCredentialsException("Erro ao cadastrar !");

		}
		return data;
		
	}
}
