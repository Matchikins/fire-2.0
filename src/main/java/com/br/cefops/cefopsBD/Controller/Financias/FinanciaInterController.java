package com.br.cefops.cefopsBD.Controller.Financias;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.cefops.cefopsBD.Services.financias.FinanceInternalServices;
import com.br.cefops.cefopsBD.data.vo.v1.FinancesInternaVo;

import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Endpoint finanças Interna",description = "EndPoint Responsavel Por Controlar o As Finanças internas")
@RestController
@CrossOrigin
@PreAuthorize("hasRole('ROLE_Financeiro')")
@RequestMapping("/api/v1/financa/interna")
public class FinanciaInterController {
	
	@Autowired
	FinanceInternalServices services;
	
	@GetMapping()
	public List<FinancesInternaVo> ObterTodasFinanças(){
		return  services.BuscarTodos();
	}
	
	@GetMapping("/{id}")
	public FinancesInternaVo FinançaId(@PathVariable("id") Long id) {
		
		return services.BuscarID(id);
	}
	
	@PostMapping
	public FinancesInternaVo CriarFinanca(@RequestBody FinancesInternaVo finance) {
		return services.NovaFinancia(finance);
	}
	
	


}
