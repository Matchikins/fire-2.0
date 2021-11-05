package com.br.cefops.cefopsBD.Controller.GestaoEscolar;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.br.cefops.cefopsBD.domain.escola.Professor;
import com.br.cefops.cefopsBD.repository.GestaoEscolar.ProfessorRepository;

import io.swagger.v3.oas.annotations.tags.Tag;
@Tag(name = "Endpoint Professores",description = "EndPoint Responsavel Por ")

@RestController
@RequestMapping("/api/v1/professors")
public class ProfessorController {
	@Autowired
	ProfessorRepository professorinterface; 
	
	

	@ResponseBody
@PostMapping(consumes = "application/json")
public ResponseEntity<?> novoprofessor(@RequestBody Professor professor) {
		Optional<Professor> optprofessor = professorinterface.findById(professor.getId());
		if (optprofessor.isPresent())
			return ResponseEntity.status(HttpStatus.CONFLICT).body("");
		professorinterface.save(professor);
		return ResponseEntity.status(HttpStatus.CREATED).body(professor);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<?> obterProfessorsId(@PathVariable Integer id) {
		Optional<Professor> optprofessor = professorinterface.findById(id);
		if (optprofessor.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(optprofessor.get());
		}
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> eliminarProfessors(@PathVariable Integer id) {
		Optional<Professor> optprofessor = professorinterface.findById(id);
		if (!optprofessor.isPresent()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		}
		professorinterface.deleteById(id);
		return ResponseEntity.status(HttpStatus.OK).body(optprofessor.get());
	}

	@ResponseBody
	@PutMapping(value = "/{id}")
	public ResponseEntity<?> alterarProfessor(@PathVariable Integer id, @RequestBody Professor professorNovo) {
		Optional<Professor> optprofessor = professorinterface.findById(id);
		if (!optprofessor.isPresent())
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body("");

		Professor professorCorrente = optprofessor.get();
		if (professorNovo.getEmail() != null && professorNovo.getEmail().length() > 0) {
			professorCorrente.setEmail(professorNovo.getEmail());
		}
		if (professorNovo.getName() != null && professorNovo.getName().length() > 0) {
			professorCorrente.setName(professorNovo.getName());
		}
		professorinterface.save(professorCorrente);
		return ResponseEntity.status(HttpStatus.OK).body(professorCorrente);
	}

@GetMapping(produces =  "application/json")
public ResponseEntity<?> obterTodosProfessores() {
		List<Professor> professors = professorinterface.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(professors);
	}

}
