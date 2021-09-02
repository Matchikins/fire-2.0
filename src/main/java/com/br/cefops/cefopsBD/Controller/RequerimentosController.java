package com.br.cefops.cefopsBD.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.br.cefops.cefopsBD.domain.Posts;
import com.br.cefops.cefopsBD.domain.requerimetos.Requerimentos;
import com.br.cefops.cefopsBD.repository.requerimentsInterface.RequerimentInterface;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/requerimetos")
public class RequerimentosController {
	@Autowired
	RequerimentInterface requerimento;
	
	@ResponseBody
	@RequestMapping(value = "/requerimetos", method = RequestMethod.POST)
	public ResponseEntity<?> novoRequeri(@RequestBody Requerimentos requeri) {
		Optional<Requerimentos> optRequerimento = requerimento.findById(requeri.getId());
		if (optRequerimento.isPresent())
			return ResponseEntity.status(HttpStatus.CONFLICT).body("");
		
		
		requerimento.save(requeri);
		return ResponseEntity.status(HttpStatus.CREATED).body(requeri);
	}
	
	@RequestMapping(value = "/requerimetos/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> obterrequerimetosID(@PathVariable Long id) {
		Optional<Requerimentos> optRequerimento = requerimento.findById(id);
		if (optRequerimento.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(optRequerimento.get());
		}
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
	}
	@RequestMapping(value = "/requerimetos", method = RequestMethod.GET)
	public ResponseEntity<?> obterAlunos() {
		List<Requerimentos> req = requerimento.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(req);
	}


}
