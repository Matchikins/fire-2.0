package com.br.cefops.cefopsBD.Controller.GestaoEscolar;
import java.util.List;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import com.br.cefops.cefopsBD.converter.DozerConvert;
import org.springframework.beans.factory.annotation.Autowired;
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

import com.br.cefops.cefopsBD.Services.escola.AlunoServices;
import com.br.cefops.cefopsBD.data.vo.v1.AlunosVo;
import com.br.cefops.cefopsBD.domain.escola.AlunosData;
import com.br.cefops.cefopsBD.repository.GestaoEscolar.AlunoRepository;
import com.br.cefops.cefopsBD.repository.GestaoEscolar.RequerimentoRepository;

import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Endpoint Alunos",description = "EndPoint Responsavel Por Controlar o EndPoint Alunos")
@RestController
@RequestMapping("/api/v1/alunos")
public class AlunoController {
	
	@Autowired
	AlunoRepository alunointerface;
	@Autowired
    RequerimentoRepository requerimento;
	@Autowired
	AlunoServices serviceAlunoServices;
	
	@GetMapping(produces = { "application/json"})
	public List<AlunosVo> obterAlunos() {
		List<AlunosVo> alunos = serviceAlunoServices.findAlunos();
		alunos.stream().forEach(p -> p.add(linkTo(methodOn(AlunoController.class).obterAlunosid(p.getKey() )).withSelfRel()));
		return alunos;
	}


	@ResponseBody
	@PostMapping(consumes = "application/json")
	public AlunosVo criarAluno(@RequestBody AlunosVo aluno) {
		AlunosVo alunos=serviceAlunoServices.creatAluno(aluno);
		return alunos;
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<AlunosData> obterAlunosid(@PathVariable("id") String id) {
		AlunosVo alunosVo=serviceAlunoServices.findAlunosID(id);
		if (!alunosVo.getKey().isEmpty()){
			return ResponseEntity.ok().body(DozerConvert.parseObject(alunosVo,AlunosData.class));

		}

		return ResponseEntity.badRequest().build();
		
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminarAluno(@PathVariable("id") String id) {
		serviceAlunoServices.delete(id);
		return ResponseEntity.ok().build();
	}


	@PutMapping(value = "/{id}")
	public AlunosVo alterarAluno(@PathVariable String id, @RequestBody AlunosVo aluno) {
		AlunosVo alunos =serviceAlunoServices.updateAluno(aluno);
		return alunos;
		
	}

	@PutMapping(value = "/v2/{id}")
	public AlunosVo atualizarAlunos(@RequestBody AlunosVo aluno) {
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
