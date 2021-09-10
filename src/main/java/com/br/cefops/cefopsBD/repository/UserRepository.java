package com.br.cefops.cefopsBD.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.br.cefops.cefopsBD.domain.User;



public interface UserRepository extends JpaRepository<User, Long> {
	@Query("SELECT u FROM User u WHERE u.userName =:userName")
	User findByUsername(@Param("userName") String userName);
	
	@Query("SELECT u FROM User u WHERE u.userEmail =:userEmail")
	User findByEmail(@Param("userEmail") String userEmail);


}
