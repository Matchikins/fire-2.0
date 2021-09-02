package com.br.cefops.cefopsBD.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.br.cefops.cefopsBD.converter.UserConverter;
import com.br.cefops.cefopsBD.data.vo.v1.AccountCredentialSignUpVO;
import com.br.cefops.cefopsBD.domain.Permission;
import com.br.cefops.cefopsBD.repository.PermissionRepository;
import com.br.cefops.cefopsBD.repository.UserRepository;

@Service
public class UserServices  implements UserDetailsService{
	@Autowired
	UserRepository repository;
	@Autowired
	UserConverter converter;
	@Autowired
	PermissionRepository repository2;
	
	public UserServices(UserRepository repository) {
		this.repository = repository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		var user = repository.findByUsername(username);
		if (user != null) {
			return user;
		} else {
			throw new UsernameNotFoundException("Username " + username + " not found");
		}
		
	}

	
	public AccountCredentialSignUpVO saveUser( String email,String password,String user, String fullname) {
		AccountCredentialSignUpVO credential= new AccountCredentialSignUpVO();
	var entity= converter.convertVoToEntity(credential);
	Permission permission= repository2.findByName("Aluno");
	
	entity.setEmail(email);
	entity.setPassword(password);
	entity.setFullName(fullname);
	entity.setUserName(user);
	entity.setAccountNonExpired(true);
	entity.setAccountNonLocked(true);
	entity.setCredentialsNonExpired(true);
	entity.setEnabled(true);
	entity.setPermissions(java.util.Arrays.asList(permission));
	var vo=converter.converterEntiteToVo(repository.save(entity));
	
		return vo;
		
	}

}
