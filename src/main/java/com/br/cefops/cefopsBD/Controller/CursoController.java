package com.br.cefops.cefopsBD.Controller;
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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.br.cefops.cefopsBD.domain.escola.CursoData;
import com.br.cefops.cefopsBD.repository.CursoRepository;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/cursos")
public class CursoController {
	
	@Autowired
	CursoRepository cursointerface;
	

	@PostMapping(consumes = "application/json")
	public CursoData criar(@RequestBody CursoData curso) {
		CursoData cursos =cursointerface.save(curso);
		return cursos;
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> obterAlunosRa(@PathVariable Integer id) {
		Optional<CursoData> optCurso = cursointerface.findById(id);
		if (optCurso.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(optCurso.get());
		}
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
	}

	@RequestMapping(value = "/cursos/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> eliminarAlunosRa(@PathVariable Integer id) {
		Optional<CursoData> optCurso = cursointerface.findById(id);
		if (!optCurso.isPresent()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		}
		cursointerface.deleteById(id);
		return ResponseEntity.status(HttpStatus.OK).body(optCurso.get());
	}

	@ResponseBody
	@PutMapping(value = "/{id}")
	public CursoData alterarCursos(@PathVariable Integer id, @RequestBody CursoData curso) {
		CursoData cursos = cursointerface.save(curso);
		return cursos;
		
		
	}

	@GetMapping()
	public List<CursoData> obterCursos() {
		List<CursoData> cursos = cursointerface.findAll();
		return  cursos;
	}

}
