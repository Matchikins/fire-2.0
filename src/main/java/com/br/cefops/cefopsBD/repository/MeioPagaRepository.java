package com.br.cefops.cefopsBD.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.cefops.cefopsBD.domain.Model.MeiosPagamento;

public interface MeioPagaRepository  extends JpaRepository<MeiosPagamento, Integer>{

}
