package com.br.cefops.cefopsBD.converter;

import org.springframework.stereotype.Service;

import com.br.cefops.cefopsBD.data.vo.v1.RequerimentoVo;
import com.br.cefops.cefopsBD.domain.escola.Requerimentos.Requerimentos;

@Service
public class RequerimentConverter {

	public RequerimentoVo convertEntityToVo(Requerimentos requerimentos) {
		RequerimentoVo vo=new RequerimentoVo();
		vo.setId(requerimentos.getId());
		vo.setAbertoEm(requerimentos.getAbertoEm());
		vo.setStatus(requerimentos.getStatus());
		vo.setResponsavel(requerimentos.getResponsavel());
		vo.setEntregue(requerimentos.getEntregue());
		vo.setConcluido(requerimentos.getConcluido());
		return vo;
	}
	
	public Requerimentos convertVoToEntity(RequerimentoVo requerimentosVo) {
		Requerimentos entity=new Requerimentos();
		entity.setAbertoEm(requerimentosVo.getAbertoEm());
		entity.setConcluido(requerimentosVo.getConcluido());
		entity.setEntregue(requerimentosVo.getEntregue());
		entity.setId(requerimentosVo.getId());
		entity.setResponsavel(requerimentosVo.getResponsavel());
		entity.setStatus(requerimentosVo.getStatus());
		entity.setTipo(requerimentosVo.getTipo());
		return entity;
		
	}
}
