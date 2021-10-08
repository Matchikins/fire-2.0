package com.br.cefops.cefopsBD.Controller;

import static org.springframework.http.ResponseEntity.ok;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
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
import com.br.cefops.cefopsBD.domain.boletos.BoletoBradescoExample;
import com.br.cefops.cefopsBD.domain.email.Email;
import com.br.cefops.cefopsBD.domain.email.EmailControll;
import com.br.cefops.cefopsBD.repository.UserRepository;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import br.com.caelum.stella.boleto.Banco;
import br.com.caelum.stella.boleto.Beneficiario;
import br.com.caelum.stella.boleto.Boleto;
import br.com.caelum.stella.boleto.Datas;
import br.com.caelum.stella.boleto.Endereco;
import br.com.caelum.stella.boleto.Pagador;
import br.com.caelum.stella.boleto.bancos.BancoDoBrasil;
import br.com.caelum.stella.boleto.transformer.GeradorDeBoleto;



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
			var fullNames =user.getFristName();
			var aluno=user.getAlunos();
			
			
			Map<Object, Object> model = new HashMap<>();
			model.put("fullInfo", aluno);
			model.put("role",levelacess );
			model.put("token", token);
			BoletoBradescoExample as =new BoletoBradescoExample();
			 Datas datas = Datas.novasDatas()
		                .comDocumento(1, 5, 2008)
		                .comProcessamento(1, 5, 2008)
		                .comVencimento(2, 5, 2008);  

		        Endereco enderecoBeneficiario = Endereco.novoEndereco()
		        		.comLogradouro("Av das Empresas, 555")  
		        		.comBairro("Bairro Grande")  
		        		.comCep("01234-555")  
		        		.comCidade("São Paulo")  
		        		.comUf("SP");  

		        //Quem emite o boleto
		        Beneficiario beneficiario = Beneficiario.novoBeneficiario()  
		                .comNomeBeneficiario("Fulano de Tal")  
		                .comAgencia("1824").comDigitoAgencia("4")  
		                .comCodigoBeneficiario("76000")  
		                .comDigitoCodigoBeneficiario("5")  
		                .comNumeroConvenio("1207113")  
		                .comCarteira("18")  
		                .comEndereco(enderecoBeneficiario)
		                .comNossoNumero("9000206");  

		        Endereco enderecoPagador = Endereco.novoEndereco()
		        		.comLogradouro("Av dos testes, 111 apto 333")  
		        		.comBairro("Bairro Teste")  
		        		.comCep("01234-111")  
		        		.comCidade("São Paulo")  
		        		.comUf("SP");  
		        
		        //Quem paga o boleto
		        Pagador pagador = Pagador.novoPagador()  
		                .comNome("Fulano da Silva")  
		                .comDocumento("111.222.333-12")
		                .comEndereco(enderecoPagador);

		        Banco banco = new BancoDoBrasil();  

		        Boleto boleto = Boleto.novoBoleto()  
		                .comBanco(banco)  
		                .comDatas(datas)  
		                .comBeneficiario(beneficiario)  
		                .comPagador(pagador)  
		                .comValorBoleto("200.00")  
		                .comNumeroDoDocumento("1234")  
		                .comInstrucoes("instrucao 1", "instrucao 2", "instrucao 3", "instrucao 4", "instrucao 5")  
		                .comLocaisDePagamento("local 1", "local 2");  

		        GeradorDeBoleto gerador = new GeradorDeBoleto(boleto);  

		        gerador.geraPDF("BancoDoBrasil.pdf");  

		        gerador.geraPNG("BancoDoBrasil.png");  

		        byte[] bPDF = gerador.geraPDF();  

		        byte[] bPNG = gerador.geraPNG();
		
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
