package com.br.cefops.cefopsBD.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.br.cefops.cefopsBD.converter.AlunoConverter;
import com.br.cefops.cefopsBD.data.vo.v1.AlunosVo;
import com.br.cefops.cefopsBD.domain.Exception.ResourceNotFoundException;
import com.br.cefops.cefopsBD.domain.escola.AlunosData;
import com.br.cefops.cefopsBD.repository.AlunoRepository;
@Service
public class AlunoServices {
	@Autowired
	AlunoRepository alunointerface;
	@Autowired
	AlunoConverter converter;
	 
	public AlunosVo creatAluno(AlunosVo alunos) {
		
		return alunos;
		
	}
	public List<AlunosVo> findAlunos() {
		return null;
		
	}
	public AlunosVo findAlunosID(String id) {
		var entity = alunointerface.findById(id).orElseThrow(()->
		new ResourceNotFoundException("Não Encontramos Nehum Aluno Com esta ID"));
		var vo = converter.convertEntityToVO(entity);

		return vo;
		
	}
	
	public AlunosVo updateAluno(AlunosVo alunos) {
		var entityAluno = converter.convertVOToEntity(alunos);
	     	entityAluno.setName(alunos.getName());
			entityAluno.setLastName(alunos.getLastName());
			entityAluno.setEmail(alunos.getEmail());
			entityAluno.setCpf(alunos.getCpf());
			entityAluno.setPhoto(alunos.getPhoto());
			var vo = converter.convertEntityToVO(alunointerface.save(entityAluno));
			return vo;
		
	}
	
	public void delete(String id) {
			AlunosData entityAlunos=alunointerface.findById(id)
					.orElseThrow(()-> new ResourceNotFoundException("Não Encontramos Nehum Aluno Com esta ID"));
		alunointerface.delete(entityAlunos);
		
		
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
