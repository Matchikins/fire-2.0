package com.br.cefops.cefopsBD.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.br.cefops.cefopsBD.domain.escola.CursoData;

public interface CursoRepository extends JpaRepository<CursoData,Integer> {



}
