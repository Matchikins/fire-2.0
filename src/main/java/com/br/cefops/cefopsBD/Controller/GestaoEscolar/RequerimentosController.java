package com.br.cefops.cefopsBD.Controller.GestaoEscolar;

import java.util.List;
import java.util.Optional;

import com.br.cefops.cefopsBD.Services.escola.RequerimentoService;
import com.br.cefops.cefopsBD.data.vo.v1.RequerimentoVo;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.br.cefops.cefopsBD.domain.escola.Requerimentos.Requerimentos;
import com.br.cefops.cefopsBD.repository.GestaoEscolar.RequerimentoRepository;

@Tag(name = "Requerimetos Controle",description = "Responsavel por controlar todoas as requisições de requerimentos")
@RestController
@RequestMapping("/api/v1/requerimetos")
public class RequerimentosController {

	@Autowired
	RequerimentoService service;

	@ResponseBody
	@PostMapping
	public ResponseEntity<RequerimentoVo> novoRequerimento(@RequestBody RequerimentoVo requerimento) {
		RequerimentoVo optRequerimento = service.buscarRequerimentoId(requerimento.getId());
		if (optRequerimento.equals(null))
			return ResponseEntity.noContent().build();
		service.novoRequerimento(optRequerimento);
		return ResponseEntity.status(HttpStatus.CREATED).body(requerimento);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<RequerimentoVo> obterRequerimetosId(@PathVariable Long id) {
		 RequerimentoVo optRequerimento = service.buscarRequerimentoId(id);
		if (optRequerimento.equals(null)) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok().body(optRequerimento);
	}
	@GetMapping()
	public ResponseEntity<List<RequerimentoVo>> obterTodosRequerimentos() {
		List<RequerimentoVo> requerimentos = service.buscarTodosRequerimentos();
		return ResponseEntity.ok(requerimentos);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<RequerimentoVo> alterarReqerimento(@PathVariable Long id, @RequestBody RequerimentoVo req) {
		 RequerimentoVo requerimentoVo=service.buscarRequerimentoId(id);
		if (requerimentoVo.equals(null)){
			ResponseEntity.notFound();
		}
		var alterado=service.alterarRequerimento(req);
		return ResponseEntity.ok(alterado);
		
	}
	
		
}
