package com.br.cefops.cefopsBD.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.cefops.cefopsBD.domain.requerimetos.TiposRequerimentos;

public interface RequerimentTypeRepository  extends JpaRepository<TiposRequerimentos,Long>  {

	

}
