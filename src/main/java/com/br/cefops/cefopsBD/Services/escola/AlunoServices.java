package com.br.cefops.cefopsBD.Services.escola;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.br.cefops.cefopsBD.converter.AlunoConverter;
import com.br.cefops.cefopsBD.converter.DozerConvert;
import com.br.cefops.cefopsBD.data.vo.v1.AlunosVo;
import com.br.cefops.cefopsBD.domain.Exception.ResourceNotFoundException;
import com.br.cefops.cefopsBD.domain.escola.AlunosData;
import com.br.cefops.cefopsBD.repository.GestaoEscolar.AlunoRepository;
@Service
public class AlunoServices {
	@Autowired
	AlunoRepository repository;
	 
	public AlunosVo creatAluno(AlunosVo alunos) {
		
		return alunos;
		
	}
	public List<AlunosVo> findAlunos() {
		return DozerConvert.parseListObjects(repository.findAll(), AlunosVo.class);
		
	}
	public AlunosVo findAlunosID(String id) {
		var entity = repository.findById(id).orElseThrow(()->
		new ResourceNotFoundException("Não Encontramos Nehum Aluno Com esta ID"));
		var vo = DozerConvert.parseObject(entity,AlunosVo.class);

		return vo;
		
	}
	
	public AlunosVo updateAluno(AlunosVo alunos) {
		var entity=DozerConvert.parseObject(alunos,AlunosData.class);
		var vo=DozerConvert.parseObject(repository.save(entity),AlunosVo.class);

					return vo;
		
	}
	
	public void delete(String id) {
			AlunosData entityAlunos=repository.findById(id)
					.orElseThrow(()-> new ResourceNotFoundException("Não Encontramos Nehum Aluno Com esta ID"));
		repository.delete(entityAlunos);
		
		
	}
//	@Transactional
//	public AlunosVo disableStudant(String id) {
//		alunointerface.disableStudant(id);
//		var entity = alunointerface.findById(id).orElseThrow(()->
//		new ResourceNotFoundException("Não Encontramos Nehum Aluno Com esta ID"));
//		var vo = converter.convertEntityToVO(entity);
//
//		return vo;
//	}
	
}
