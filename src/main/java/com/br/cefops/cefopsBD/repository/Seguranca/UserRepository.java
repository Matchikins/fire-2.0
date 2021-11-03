package com.br.cefops.cefopsBD.repository.Seguranca;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.br.cefops.cefopsBD.domain.seguranca.User;



public interface UserRepository extends JpaRepository<User, Long> {
	@Query("SELECT u FROM User u WHERE u.userName =:userName")
	User findByUsername(@Param("userName") String userName);
    public User findUserByEmail(String email);
    

	
	


}
