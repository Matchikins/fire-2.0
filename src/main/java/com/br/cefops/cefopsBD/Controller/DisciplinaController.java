package com.br.cefops.cefopsBD.Controller;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.br.cefops.cefopsBD.domain.Professor;
import com.br.cefops.cefopsBD.domain.escola.DisciplinasData;
import com.br.cefops.cefopsBD.repository.DisciplinaRepository;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/diciplinas")

public class DisciplinaController {
	@Autowired
	DisciplinaRepository diciplinainterface;
	
	
	@ResponseBody
	@PostMapping(consumes  =  "application/json")
	public ResponseEntity<?> novodiciplina(@RequestBody DisciplinasData diciplina) {
		Optional<DisciplinasData> optdiciplina = diciplinainterface.findById(diciplina.getId());
		if (optdiciplina.isPresent())
			return ResponseEntity.status(HttpStatus.CONFLICT).body("");
		diciplinainterface.save(diciplina);
		return ResponseEntity.status(HttpStatus.CREATED).body(diciplina);
	}


@GetMapping
public ResponseEntity<?> obterdiciplinas() {
		List<DisciplinasData> diciplinas = diciplinainterface.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(diciplinas);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> eliminarprofessorsRa(@PathVariable Integer id) {
		Optional<DisciplinasData> optdiciplinas = diciplinainterface.findById(id);
		if (!optdiciplinas.isPresent()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		}
		diciplinainterface.deleteById(id);
		return ResponseEntity.status(HttpStatus.OK).body(optdiciplinas.get());
	}

}
