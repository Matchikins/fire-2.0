package com.br.cefops.cefopsBD.repository.GestaoEscolar.Documentos;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.br.cefops.cefopsBD.domain.escola.Documentos.Endereço;

public interface EndrerecoRepository extends JpaRepository<Endereço,Long >  {
	
	@Query(value = "SELECT E FROM Endereço as E  WHERE E.alunoId.id = ?1")
	Endereço buscarAlunoId(String id);

}
