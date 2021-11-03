package com.br.cefops.cefopsBD.repository.GestaoEscolar;

import com.br.cefops.cefopsBD.domain.escola.Curso.NotasAlunosData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotasRepository  extends JpaRepository<NotasAlunosData,Long> {


    List<NotasAlunosData> findAllByAlunoId(String id);
}
