package com.br.cefops.cefopsBD.converter;

import org.springframework.stereotype.Service;

import com.br.cefops.cefopsBD.data.vo.v1.AlunosVo;
import com.br.cefops.cefopsBD.domain.escola.AlunosData;

@Service
public class AlunoConverter {
		
	public AlunosVo convertEntityToVO(AlunosData alunos) {
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
	public AlunosData  convertVOToEntity(AlunosVo alunosVo) {
		AlunosData entityAlunos= new AlunosData();
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
