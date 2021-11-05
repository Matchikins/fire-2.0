package com.br.cefops.cefopsBD.repository.GestaoEscolar;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.br.cefops.cefopsBD.domain.escola.Requerimentos.Requerimentos;

import java.util.List;

@Repository
public interface RequerimentoRepository extends  JpaRepository<Requerimentos, Long>{


	@Modifying
	@Query("UPDATE Requerimentos r SET r.Responsavel = :responsavel,r.Status = :status  WHERE r.id =:id")
	void setResponsavel(
			@Param("id") Long id,
			@Param("responsavel") String responsavel,
			@Param("status") String status
			);
	

	@Query(value = "SELECT R FROM Requerimentos as R  WHERE R.aluno.Id = ?1")
   List<Requerimentos> buscarAlunoId(String id);



}
