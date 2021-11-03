package com.br.cefops.cefopsBD.Controller.GestaoEscolar;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.br.cefops.cefopsBD.domain.escola.Requerimentos.Requerimentos;
import com.br.cefops.cefopsBD.repository.GestaoEscolar.requerimentsInterface;


@RestController
@CrossOrigin
@RequestMapping("/api/v1/requerimetos")
public class RequerimentosController {
	@Autowired
	requerimentsInterface repository;


	
	
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
	public ResponseEntity<?> obterrequerimetosID(@PathVariable String id) {
		List<Requerimentos> optRequerimento = repository.buscarAlunoId(id);
		if (optRequerimento.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		}
		return ResponseEntity.status(HttpStatus.OK).body(optRequerimento);
	}
	@GetMapping()
	public ResponseEntity<?> GetRequeriments() {
		List<Requerimentos> req = repository.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(req);
	}

	@PutMapping(value = "/{id}")
	public Requerimentos alterarReq(@PathVariable String id, @RequestBody Requerimentos req) {
		Requerimentos alunos =repository.save(req);
		return alunos;
		
	}
	
		
}
