package com.br.cefops.cefopsBD.repository.GestaoEscolar;
import org.springframework.data.jpa.repository.JpaRepository;

import com.br.cefops.cefopsBD.domain.escola.Curso.DisciplinasData;

public interface DisciplinaRepository extends JpaRepository<DisciplinasData,Integer> {

}
