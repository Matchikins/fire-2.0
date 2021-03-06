package com.br.cefops.cefopsBD.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.cefops.cefopsBD.converter.DozerConvert;
import com.br.cefops.cefopsBD.data.vo.v1.RequerimentsTypysVo;
import com.br.cefops.cefopsBD.domain.requerimetos.TiposRequerimentos;
import com.br.cefops.cefopsBD.repository.RequerimentTypeRepository;

@Service
public class RequerimentTaypeService {
	@Autowired
	RequerimentTypeRepository repository;
	
	
	public List<RequerimentsTypysVo> FindAllRequerimentsType() {
	
		return DozerConvert.parseListObjects(repository.findAll(), RequerimentsTypysVo.class);
	}
	
	public RequerimentsTypysVo CreateRequerimentType(RequerimentsTypysVo requeriment) {
		var entity=DozerConvert.parseObject(requeriment, TiposRequerimentos.class);
		var vo=DozerConvert.parseObject(repository.save(entity), RequerimentsTypysVo.class);
		return vo;
		
	}
	
	public RequerimentsTypysVo updateRequerimentsTypys(RequerimentsTypysVo requeriment) {
		
		return null;
		
	}
	
	

	

}
