package com.br.cefops.cefopsBD.repository.Financias;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.cefops.cefopsBD.domain.Financias.FinanceInterna;

public interface FinanceInRepository  extends JpaRepository<FinanceInterna, Long> {

}
