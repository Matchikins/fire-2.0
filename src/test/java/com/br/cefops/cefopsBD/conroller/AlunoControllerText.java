package com.br.cefops.cefopsBD.conroller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;

import com.br.cefops.cefopsBD.domain.Exception.ResourceNotFoundException;
import com.br.cefops.cefopsBD.domain.escola.AlunosData;
import com.br.cefops.cefopsBD.repository.AlunoRepository;
@SpringBootTest
@WebAppConfiguration
class AlunoControllerText {

	@Autowired 
	AlunoRepository services;
	@Test
	void GetAlunoById() throws ResourceNotFoundException {
	Optional<AlunosData> aluno=services.findById("teste1");
	assertEquals("Emison", aluno.get().getName()); 
	assertEquals("Dias", aluno.get().getLastName());
	assertEquals("fg@1.com", aluno.get().getEmail());

	}

}
