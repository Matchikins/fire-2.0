package com.br.cefops.cefopsBD.repository.requerimentsInterface;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.cefops.cefopsBD.domain.requerimetos.Requerimentos;

public interface RequerimentInterface extends  JpaRepository<Requerimentos, Long> {

}
