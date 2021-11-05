package com.br.cefops.cefopsBD.Controller.GestaoEscolar;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.br.cefops.cefopsBD.domain.escola.Curso.CursoData;
import com.br.cefops.cefopsBD.repository.GestaoEscolar.CursoRepository;

@RestController
@RequestMapping("/api/v1/cursos")
public class CursoController {
	
	@Autowired
	CursoRepository cursointerface;
	

	@PostMapping(consumes = "application/json")
	public CursoData criarCurso(@RequestBody CursoData curso) {
		CursoData cursos =cursointerface.save(curso);
		return cursos;
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> obterCursoId(@PathVariable Integer id) {
		Optional<CursoData> optCurso = cursointerface.findById(id);
		if (optCurso.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(optCurso.get());
		}
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
	}

	@DeleteMapping(value = "/cursos/{id}")
	public ResponseEntity<?> eliminarCurso(@PathVariable Integer id) {
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
