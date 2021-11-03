package com.br.cefops.cefopsBD.repository.GestaoEscolar;
import org.springframework.data.jpa.repository.JpaRepository;

import com.br.cefops.cefopsBD.domain.escola.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Integer> {

}
