package com.br.cefops.cefopsBD.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.cefops.cefopsBD.domain.FinanceInterna;

public interface FinanceInRepository  extends JpaRepository<FinanceInterna, Long> {

}
