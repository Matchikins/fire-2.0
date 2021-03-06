package com.br.cefops.cefopsBD.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.cefops.cefopsBD.Services.RequerimentTaypeService;
import com.br.cefops.cefopsBD.data.vo.v1.RequerimentsTypysVo;

import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Endpoint Tipos de requerimentos",description = "EndPoint Responsavel Por Controlar os Tipos de Requerminetos")
@RestController
@CrossOrigin
@RequestMapping("/api/v1/tiposrequerimentos")
public class RequerimentTaypeController {
@Autowired
RequerimentTaypeService service;

	@GetMapping()
	public List<RequerimentsTypysVo> getAllTaypesRequeriment() {
		
		return service.FindAllRequerimentsType();
	}
}
