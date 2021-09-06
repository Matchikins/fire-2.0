package com.br.cefops.cefopsBD.Controller;

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
import com.br.cefops.cefopsBD.Services.UserServices;
import com.br.cefops.cefopsBD.data.vo.v1.AccountCredentialSignUpVO;
import com.br.cefops.cefopsBD.data.vo.v1.AccountCredentialsVO;
import com.br.cefops.cefopsBD.repository.UserRepository;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;



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
			
			Map<Object, Object> model = new HashMap<>();
			model.put("userFullName", user.getFullName());
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
			var fullname=data.getFullName();
			BCryptPasswordEncoder bCryptPasswordEncoder= new BCryptPasswordEncoder(13);
			var result =bCryptPasswordEncoder.encode(password);
			if (user.isEmpty()) {
			throw new BadCredentialsException("Erro ao cadastrar !");
		}
			
			serviceUser.saveUser(email, result, user, fullname);
			
		} catch (AuthenticationException e) {
			throw new BadCredentialsException("Erro ao cadastrar !");

		}
		return data;
		
	}
}
