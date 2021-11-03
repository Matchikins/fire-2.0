package com.br.cefops.cefopsBD.Services.financias;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.cefops.cefopsBD.converter.DozerConvert;
import com.br.cefops.cefopsBD.data.vo.v1.FinancesInternaVo;
import com.br.cefops.cefopsBD.domain.Financias.FinanceInterna;
import com.br.cefops.cefopsBD.domain.Exception.ResourceNotFoundException;
import com.br.cefops.cefopsBD.repository.Financias.FinanceInRepository;

@Service
public class FinanceInternalServices {
	@Autowired
	FinanceInRepository repository;
	
	public List<FinancesInternaVo> BuscarTodos() {
		return DozerConvert.parseListObjects(repository.findAll(), FinancesInternaVo.class);
		
	}
	
	public FinancesInternaVo BuscarID(Long id) {
		
		var entity=repository.findById(id)
				.orElseThrow(() -> 
				new ResourceNotFoundException("Não Foi Encontrado Nehum Registro Com Esta Id"));
		return DozerConvert.parseObject(entity, FinancesInternaVo.class);
		
	}
	
	public FinancesInternaVo NovaFinancia(FinancesInternaVo financia ) {
		var entity =DozerConvert.parseObject(financia, FinanceInterna.class);
		var vo= DozerConvert.parseObject(repository.save(entity), FinancesInternaVo.class);
		return vo;
	}
	
	
}
