package com.br.cefops.cefopsBD.Services.escola;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.cefops.cefopsBD.converter.DozerConvert;
import com.br.cefops.cefopsBD.data.vo.v1.RequerimentsTypysVo;
import com.br.cefops.cefopsBD.domain.escola.Requerimentos.TiposRequerimentos;
import com.br.cefops.cefopsBD.repository.GestaoEscolar.RequerimentTypeRepository;

@Service
public class RequerimentTaypeService {
	@Autowired
	RequerimentTypeRepository repository;
	
	
	public List<RequerimentsTypysVo> EncontrarTodosTiposRequerimentos() {
	
		return DozerConvert.parseListObjects(repository.findAll(), RequerimentsTypysVo.class);
	}
	
	public RequerimentsTypysVo CriarTopoRequerimento(RequerimentsTypysVo requeriment) {
		var entity=DozerConvert.parseObject(requeriment, TiposRequerimentos.class);
		var vo=DozerConvert.parseObject(repository.save(entity), RequerimentsTypysVo.class);
		return vo;
		
	}
	
	public RequerimentsTypysVo AtualizarTipoRequerimento(RequerimentsTypysVo requeriment) {
		
		return null;
		
	}
	
	

	

}
