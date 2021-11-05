package com.br.cefops.cefopsBD.Controller.GestaoEscolar.Documentos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.cefops.cefopsBD.Services.escola.EnderecoService;
import com.br.cefops.cefopsBD.data.vo.v1.EnderecoVo;

import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Endpoint endereco",description = "EndPoint Responsavel Por Controlar o endereco")
@RestController
@RequestMapping("/api/v1/endereco")
public class EnderecoController {
	@Autowired
	EnderecoService service;
	
	@GetMapping(value = "/{id}")
	public EnderecoVo buscarPorID(@PathVariable("id") String id) {	
		return service.BuscarEnderecoPorAlunoID(id) ;
	}
	
	@PostMapping(consumes = "application/json")
	public EnderecoVo novoEndereco(@RequestBody EnderecoVo endereco) {
		return service.NovoEndereco(endereco);
	}
	
	@PutMapping(value = "/{id}")
	public EnderecoVo alterarEndereco(@PathVariable Long id, @RequestBody EnderecoVo endereco) {
		return service.AtualizarEndereco(endereco);
		
	}
		

}
