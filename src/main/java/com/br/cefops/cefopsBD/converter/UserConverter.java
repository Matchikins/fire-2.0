package com.br.cefops.cefopsBD.converter;

import org.springframework.stereotype.Service;

import com.br.cefops.cefopsBD.data.vo.v1.AccountCredentialSignUpVO;
import com.br.cefops.cefopsBD.domain.seguranca.User;

@Service
public class UserConverter {

	public AccountCredentialSignUpVO converterEntiteToVo(User user) {
		AccountCredentialSignUpVO vo= new AccountCredentialSignUpVO();
		vo.setEmail(user.getEmail());
		vo.setPassword(user.getPassword());
		vo.setUsername(user.getUsername());
		vo.setFristName(user.getFristName());
		vo.setLastName(user.getLastName());
	
		return vo;
	}
	
	public User convertVoToEntity(AccountCredentialSignUpVO vo) {
		User entityUser= new User();
		entityUser.setEmail(vo.getEmail());
		entityUser.setPassword(vo.getPassword());
		entityUser.setUserName(vo.getUsername());
		entityUser.setFristName(vo.getFristName());
		entityUser.setLastName(vo.getLastName());
	
		
		return entityUser;
	}
}
