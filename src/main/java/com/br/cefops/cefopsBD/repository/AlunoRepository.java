package com.br.cefops.cefopsBD.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.br.cefops.cefopsBD.domain.escola.AlunosData;
@Repository
public interface AlunoRepository extends  JpaRepository<AlunosData,String> {

	
	
//	@Modifying
//	@Query("UPDATE Alunos p SET p.enabled = false WHERE p.id =:id")
//	void disableStudant(@Param("id") String id);
	
		

	}



