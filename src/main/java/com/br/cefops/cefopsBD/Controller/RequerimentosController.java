package com.br.cefops.cefopsBD.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.br.cefops.cefopsBD.data.vo.v1.AlunosVo;
import com.br.cefops.cefopsBD.domain.Alunos;
import com.br.cefops.cefopsBD.domain.Posts;
import com.br.cefops.cefopsBD.domain.requerimetos.Requerimentos;
import com.br.cefops.cefopsBD.domain.services.requerimentos.RequerimentoServices;
import com.br.cefops.cefopsBD.repository.requerimentsInterface.RequerimentInterface;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/requerimetos")
public class RequerimentosController {
	@Autowired
	RequerimentInterface repository;
	@Autowired
	RequerimentoServices service;
	
	
	@ResponseBody
	@PostMapping
	public ResponseEntity<?> novoRequeri(@RequestBody Requerimentos requeri) {
		Optional<Requerimentos> optRequerimento = repository.findById(requeri.getId());
		if (optRequerimento.isPresent())
			return ResponseEntity.status(HttpStatus.CONFLICT).body("");
		
		
		repository.save(requeri);
		return ResponseEntity.status(HttpStatus.CREATED).body(requeri);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> obterrequerimetosID(@PathVariable Long id) {
		Optional<Requerimentos> optRequerimento = repository.findById(id);
		if (optRequerimento.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(optRequerimento.get());
		}
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
	}
	@GetMapping()
	public ResponseEntity<?> GetRequeriments() {
		List<Requerimentos> req = repository.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(req);
	}

	@PutMapping(value = "/{id}")
	public Requerimentos alterarAluno(@PathVariable String id, @RequestBody Requerimentos req) {
		Requerimentos alunos =repository.save(req);
		return alunos;
		
	}
}
