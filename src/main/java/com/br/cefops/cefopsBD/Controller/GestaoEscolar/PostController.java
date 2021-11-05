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

import com.br.cefops.cefopsBD.domain.escola.Posts;
import com.br.cefops.cefopsBD.repository.GestaoEscolar.PostRepository;

import io.swagger.v3.oas.annotations.tags.Tag;
@Tag(name = "Endpoint Post",description = "EndPoint Responsavel Por Criar Postes para Tela Inicial Do App")
@RestController
@RequestMapping("/api/v1/post")

public class PostController {
	@Autowired
	PostRepository postsinterface;
	
@GetMapping(produces =  "application/json")
public ResponseEntity<?> obterTodosPostes() {
		List<Posts> posts = postsinterface.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(posts);
	}
	
@GetMapping(value = "/{id}")
	public ResponseEntity<?> obterPostId(@PathVariable Integer id) {
		Optional<Posts> optPosts = postsinterface.findById(id);
		if (optPosts.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(optPosts.get());
		}
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
	}
	

	@ResponseBody
	@PostMapping(consumes = "application/json")
	public ResponseEntity<?> novoPost(@RequestBody Posts post) {
		Optional<Posts> optposts = postsinterface.findById(post.getId());
		if (optposts.isPresent())
			return ResponseEntity.status(HttpStatus.CONFLICT).body("");
		postsinterface.save(post);
		return ResponseEntity.status(HttpStatus.CREATED).body(post);
	}
	
	
	@ResponseBody
	@PutMapping(value = "/{id}")
	public ResponseEntity<?> alterarPost(@PathVariable Integer id, @RequestBody Posts postNovo) {
		Optional<Posts> optPost = postsinterface.findById(id);
		if (!optPost.isPresent())
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Não encontrado");

		Posts postCorrente = optPost.get();
			postCorrente.setTitle(postNovo.getTitle());
			postCorrente.setPoste(postNovo.getPoste());
		
		postsinterface.save(postCorrente);
		return ResponseEntity.status(HttpStatus.OK).body(postCorrente);
	}

	
	

}
