package com.br.cefops.cefopsBD.converter;

import org.springframework.stereotype.Service;

import com.br.cefops.cefopsBD.data.vo.v1.RequerimentVo;
import com.br.cefops.cefopsBD.domain.requerimetos.Requerimentos;

@Service
public class RequerimentConverter {

	public RequerimentVo convertEntityToVo(Requerimentos requerimentos) {
		RequerimentVo vo=new RequerimentVo();
		vo.setId(requerimentos.getId());
		vo.setTipo(requerimentos.getTipo());
		vo.setAbertoEm(requerimentos.getAbertoEm());
		vo.setAluno(requerimentos.getAluno());
		vo.setStatus(requerimentos.getStatus());
		vo.setResponsavel(requerimentos.getResponsavel());
		vo.setEntregue(requerimentos.getEntregue());
		vo.setConcluido(requerimentos.getConcluido());
		return vo;
	}
	
	public Requerimentos convertVoToEntity(RequerimentVo requerimentosVo) {
		Requerimentos entity=new Requerimentos();
		entity.setAbertoEm(requerimentosVo.getAbertoEm());
		entity.setAluno(requerimentosVo.getAluno());
		entity.setConcluido(requerimentosVo.getConcluido());
		entity.setEntregue(requerimentosVo.getEntregue());
		entity.setId(requerimentosVo.getId());
		entity.setResponsavel(requerimentosVo.getResponsavel());
		entity.setStatus(requerimentosVo.getStatus());
		entity.setTipo(requerimentosVo.getTipo());
		return entity;
		
	}
}
