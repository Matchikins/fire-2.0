package com.br.cefops.cefopsBD.Controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.br.cefops.cefopsBD.Services.AlunoServices;
import com.br.cefops.cefopsBD.data.vo.v1.AlunosVo;
import com.br.cefops.cefopsBD.domain.Alunos;
import com.br.cefops.cefopsBD.repository.AlunoRepository;

import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Endpoint Alunos",description = "EndPoint Responsavel Por Controlar o EndPoint Alunos")
@RestController
@CrossOrigin
@RequestMapping("/api/v1/alunos")
public class AlunoController {
	
	@Autowired
	AlunoRepository alunointerface;
	@Autowired
	AlunoServices serviceAlunoServices;
	
	@CrossOrigin(origins = "http://localhost:8810")
	@GetMapping(produces = { "application/json"})
	public List<Alunos> obterAlunos() {
		List<Alunos> alunos = alunointerface.findAll();
		return alunos;
	}


	@ResponseBody
	@PostMapping(consumes = "application/json")
	public Alunos creat(@RequestBody Alunos aluno) {
		Alunos alunos=alunointerface.save(aluno);
		return alunos;
	}

	@GetMapping(value = "/{id}")
	public AlunosVo obterAlunosid(@PathVariable("id") String id) {	
		return serviceAlunoServices.findAlunosID(id);
		
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminarAlunos(@PathVariable("id") String id) {
		serviceAlunoServices.delete(id);
		return ResponseEntity.ok().build();
	}


	@PutMapping(value = "/{id}")
	public Alunos alterarAluno(@PathVariable String id, @RequestBody Alunos aluno) {
		Alunos alunos =alunointerface.save(aluno);
		return alunos;
		
	}

	@PutMapping(value = "/v2/{id}")
	public AlunosVo updAlunos(@RequestBody AlunosVo aluno) {
		AlunosVo alunosVo =serviceAlunoServices.updateAluno(aluno);
		return alunosVo;
		
	}
	@PatchMapping(value = "/{id}")
	public ResponseEntity<AlunosVo> disableStudant(@PathVariable("id") String id) {	
		serviceAlunoServices.disableStudant(id);
		return 	 ResponseEntity.ok().build();

		
	}

	
	
}
