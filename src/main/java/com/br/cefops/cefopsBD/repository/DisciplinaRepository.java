package com.br.cefops.cefopsBD.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.br.cefops.cefopsBD.domain.escola.DisciplinasData;

public interface DisciplinaRepository extends JpaRepository<DisciplinasData,Integer> {

}
