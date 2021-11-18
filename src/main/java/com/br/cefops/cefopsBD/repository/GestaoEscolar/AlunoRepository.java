package com.br.cefops.cefopsBD.repository.GestaoEscolar;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

	@Query("SELECT a FROM AlunosData a WHERE a.name LIKE LOWER(CONCAT ('%', :nome, '%')) ")
	Page<AlunosData> findByName(@Param("nome") String nome, Pageable pageable);
	
		

	}



