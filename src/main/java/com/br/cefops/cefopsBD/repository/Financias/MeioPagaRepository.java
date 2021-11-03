package com.br.cefops.cefopsBD.repository.Financias;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.cefops.cefopsBD.domain.Financias.MeiosPagamento;

public interface MeioPagaRepository  extends JpaRepository<MeiosPagamento, Integer>{

}
