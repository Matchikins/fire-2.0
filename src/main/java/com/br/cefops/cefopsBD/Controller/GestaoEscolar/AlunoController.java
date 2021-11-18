package com.br.cefops.cefopsBD.Controller.GestaoEscolar;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import com.br.cefops.cefopsBD.converter.DozerConvert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.br.cefops.cefopsBD.Services.escola.AlunoServices;
import com.br.cefops.cefopsBD.data.vo.v1.AlunosVo;
import com.br.cefops.cefopsBD.domain.escola.AlunosData;


import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Endpoint Alunos",description = "EndPoint Responsavel Por Controlar o EndPoint Alunos")
@RestController
@RequestMapping("/api/v1/alunos")
public class AlunoController {


	@Autowired
	AlunoServices serviceAlunoServices;
	
	@GetMapping(produces = { "application/json"})
public ResponseEntity  obterAlunos(
		@RequestParam(value = "page",defaultValue = "0") int page,
		@RequestParam(value = "limit",defaultValue = "15") int limit,
		@RequestParam(value = "direction",defaultValue = "asc") String direction) {
		var sortDirection="desc".equalsIgnoreCase(direction)
				? Sort.Direction.DESC
				: Sort.Direction.ASC;
		Pageable pageable= PageRequest.of(page, limit,Sort.by(sortDirection,"Name"));

		Page<AlunosVo> alunos = serviceAlunoServices.findAlunos(pageable);

		alunos.stream().forEach(aluno -> aluno.add(linkTo(methodOn(AlunoController.class)
				.obterAlunosid(aluno.getKey())).withSelfRel()));
		return ResponseEntity.ok(alunos);
	}
	@GetMapping(value = "/buscarnome/{nome}",produces = { "application/json"})
	public ResponseEntity  obterAlunosPorNome(
			@PathVariable("nome") String nome,
			@RequestParam(value = "page",defaultValue = "0") int page,
			@RequestParam(value = "limit",defaultValue = "15") int limit,
			@RequestParam(value = "direction",defaultValue = "asc") String direction) {
		var sortDirection="desc".equalsIgnoreCase(direction)
				? Sort.Direction.DESC
				: Sort.Direction.ASC;
		Pageable pageable= PageRequest.of(page, limit,Sort.by(sortDirection,"name"));

		Page<AlunosVo> alunos = serviceAlunoServices.findAlunosByName(nome,pageable);

		alunos.stream().forEach(aluno -> aluno.add(linkTo(methodOn(AlunoController.class)
				.obterAlunosid(aluno.getKey())).withSelfRel()));
		try {
			if (alunos != null) {
				return ResponseEntity.ok(alunos);

			}

		} catch (Exception e) {
			return 	ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok("alunos") ;
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
		AlunosVo alunos =serviceAlunoServices.updateAluno(aluno);
		return alunos;
		
	}
//	@PatchMapping(value = "/{id}")
//	public ResponseEntity<AlunosVo> disableStudant(@PathVariable("id") String id) {	
//		serviceAlunoServices.disableStudant(id);
//		return 	 ResponseEntity.ok().build();
//
//		
//	}

	
	
}
