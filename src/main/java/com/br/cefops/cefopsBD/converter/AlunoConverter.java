package com.br.cefops.cefopsBD.converter;

import org.springframework.stereotype.Service;

import com.br.cefops.cefopsBD.data.vo.v1.AlunosVo;
import com.br.cefops.cefopsBD.domain.Alunos;

@Service
public class AlunoConverter {
		
	public AlunosVo convertEntityToVO(Alunos alunos) {
			AlunosVo vo= new AlunosVo();
			vo.setId(alunos.getId());
			vo.setCpf(alunos.getCpf());
			vo.setName(alunos.getName());
			vo.setLastName(alunos.getLastName());
			vo.setPhoto(alunos.getPhoto());
			vo.setEmail(alunos.getEmail());
			vo.setEnable(alunos.getEnable());
			
			return vo;
			
		}
	public Alunos  convertVOToEntity(AlunosVo alunosVo) {
		Alunos entityAlunos= new Alunos();
		entityAlunos.setId(alunosVo.getId());
		entityAlunos.setCpf(alunosVo.getCpf());
		entityAlunos.setName(alunosVo.getName());
		entityAlunos.setLastName(alunosVo.getLastName());
		entityAlunos.setPhoto(alunosVo.getPhoto());
		entityAlunos.setEmail(alunosVo.getEmail());
		entityAlunos.setEnable(alunosVo.getEnable());
		
		return entityAlunos;
		
	}
	
}
