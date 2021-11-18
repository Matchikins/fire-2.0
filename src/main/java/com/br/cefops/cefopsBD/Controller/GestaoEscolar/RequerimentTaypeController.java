package com.br.cefops.cefopsBD.Controller.GestaoEscolar;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.cefops.cefopsBD.Services.escola.RequerimentTaypeService;
import com.br.cefops.cefopsBD.data.vo.v1.RequerimentsTypysVo;

import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Endpoint Tipos de requerimentos",description = "EndPoint Responsavel Por Controlar os Tipos de Requerminetos")
@RestController
@RequestMapping("/api/v1/tiposrequerimentos")
public class RequerimentTaypeController {
@Autowired
RequerimentTaypeService service;

	@GetMapping()
	public List<RequerimentsTypysVo> buscarTodosTiposdeRequerimentos() {
		
		return service.EncontrarTodosTiposRequerimentos();
	}
}
