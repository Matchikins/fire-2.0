package com.br.cefops.cefopsBD.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.br.cefops.cefopsBD.domain.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Integer> {

}
