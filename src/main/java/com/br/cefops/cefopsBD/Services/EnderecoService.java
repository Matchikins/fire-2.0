package com.br.cefops.cefopsBD.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.cefops.cefopsBD.converter.DozerConvert;
import com.br.cefops.cefopsBD.data.vo.v1.EnderecoVo;
import com.br.cefops.cefopsBD.domain.Endereço;
import com.br.cefops.cefopsBD.domain.Exception.ResourceNotFoundException;
import com.br.cefops.cefopsBD.repository.EndrerecoRepository;

@Service
public class EnderecoService {

	@Autowired
	EndrerecoRepository repository;
	
	
	public EnderecoVo NovoEndereco(EnderecoVo enderecoVo) {
		var entity=DozerConvert.parseObject(enderecoVo, Endereço.class);
		var vo=DozerConvert.parseObject(repository.save(entity), EnderecoVo.class);
		return vo;
	}
	
	public EnderecoVo BuscarEnderecoPorID(Long id) {
		var entity=repository.findById(id).orElseThrow(()->
		new ResourceNotFoundException("Não Encontramos Nehum Endereço Com esta ID"));
		return DozerConvert.parseObject(entity, EnderecoVo.class);
		
	}
	public EnderecoVo AtualizarEndereco(EnderecoVo endereco) {
		var entity=repository.findById(endereco.getId()).orElseThrow(()->
		new ResourceNotFoundException("Não Encontramos Nehum Endereço Com esta ID"));
		
		entity.setAlunos(endereco.getAlunos());
		entity.setBairro(endereco.getBairro());
		entity.setCep(endereco.getCep());
		entity.setCidade(endereco.getCidade());
		entity.setComplemento(endereco.getComplemento());
		entity.setEstado(endereco.getEstado());
		entity.setNumero(endereco.getNumero());
		entity.setRua(endereco.getRua());
		entity.setUf(endereco.getUf());
		
		var vo=DozerConvert.parseObject(repository.save(entity), EnderecoVo.class);
		return vo;
		
	}
	
	
}
