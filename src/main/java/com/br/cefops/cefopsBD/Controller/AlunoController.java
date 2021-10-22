package com.br.cefops.cefopsBD.Controller;
import java.util.List;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.br.cefops.cefopsBD.Services.AlunoServices;
import com.br.cefops.cefopsBD.data.vo.v1.AlunosVo;
import com.br.cefops.cefopsBD.domain.escola.AlunosData;
import com.br.cefops.cefopsBD.repository.AlunoRepository;

import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Endpoint Alunos",description = "EndPoint Responsavel Por Controlar o EndPoint Alunos")
@RestController
@RequestMapping("/api/v1/alunos")
public class AlunoController {
	
	@Autowired
	AlunoRepository alunointerface;
	@Autowired
	AlunoServices serviceAlunoServices;
	
	@GetMapping(produces = { "application/json"})
	public List<AlunosData> obterAlunos() {
		List<AlunosData> alunos = alunointerface.findAll();
		return alunos;
	}


	@ResponseBody
	@PostMapping(consumes = "application/json")
	public AlunosData creat(@RequestBody AlunosData aluno) {
		AlunosData alunos=alunointerface.save(aluno);
		return alunos;
	}

	@GetMapping(value = "/{id}")
	public AlunosVo obterAlunosid(@PathVariable("id") String id) {	
		AlunosVo alunosVo=serviceAlunoServices.findAlunosID(id);
		alunosVo.add(linkTo(methodOn(EnderecoController.class).buscarPorID( (long) 1)).withRel("Endereço"));
		alunosVo.add(linkTo(methodOn(RequerimentosController.class).obterrequerimetosID( (long) 1)).withRel("Requerimentos"));
		return alunosVo;
		
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminarAlunos(@PathVariable("id") String id) {
		serviceAlunoServices.delete(id);
		return ResponseEntity.ok().build();
	}


	@PutMapping(value = "/{id}")
	public AlunosData alterarAluno(@PathVariable String id, @RequestBody AlunosData aluno) {
		AlunosData alunos =alunointerface.save(aluno);
		return alunos;
		
	}

	@PutMapping(value = "/v2/{id}")
	public AlunosVo updAlunos(@RequestBody AlunosVo aluno) {
		AlunosVo alunosVo =serviceAlunoServices.updateAluno(aluno);
		return alunosVo;
		
	}
//	@PatchMapping(value = "/{id}")
//	public ResponseEntity<AlunosVo> disableStudant(@PathVariable("id") String id) {	
//		serviceAlunoServices.disableStudant(id);
//		return 	 ResponseEntity.ok().build();
//
//		
//	}

	
	
}
