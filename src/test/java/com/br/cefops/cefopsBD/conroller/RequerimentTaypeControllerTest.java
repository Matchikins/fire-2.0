package com.br.cefops.cefopsBD.conroller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.web.WebAppConfiguration;

import com.br.cefops.cefopsBD.Controller.RequerimentosController;
import com.br.cefops.cefopsBD.Services.RequerimentTaypeService;
import com.br.cefops.cefopsBD.domain.requerimetos.TiposRequerimentos;

@SpringBootTest
@WebAppConfiguration
class RequerimentTaypeControllerTest {
	
	@Autowired
	private RequerimentosController Controller;
	@Autowired
	private RequerimentTaypeService service;
		String  reqLists="Data" ;
		HttpStatus statusConnection=HttpStatus.OK;
	@Test
	public void TaypesRequerimentsStatus() {
		ResponseEntity<?> requeriments= Controller.GetRequeriments();
		assertEquals(statusConnection, requeriments.getStatusCode());
	}	
	
	@Test
	public void GetRequerimentTaypeCmproMatri() {
		var requeriments = service.FindAllRequerimentsType();
		assertEquals("Comprovante Matrícula", requeriments.get(0).getName());
	}	
	

}
