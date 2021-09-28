package com.br.cefops.cefopsBD.domain.services.requerimentos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.br.cefops.cefopsBD.data.vo.v1.AlunosVo;
import com.br.cefops.cefopsBD.domain.Exception.ResourceNotFoundException;
import com.br.cefops.cefopsBD.domain.requerimetos.Requerimentos;
import com.br.cefops.cefopsBD.repository.requerimentsInterface.RequerimentInterface;

@Service
public class RequerimentoServices {
	@Autowired
	RequerimentInterface repoInterface;
	
	
	@Transactional
	public void setResponsavelReq(Long id, String respon,String st) {
		repoInterface.setResponsavel(id, respon,st);
		var entity = repoInterface.findById(id).orElseThrow(()->
		new ResourceNotFoundException("Não Encontramos Nehum Req Com esta ID"));
		
		
	}
	


}
