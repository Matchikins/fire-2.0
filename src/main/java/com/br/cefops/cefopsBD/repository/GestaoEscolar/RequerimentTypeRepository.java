package com.br.cefops.cefopsBD.repository.GestaoEscolar;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.cefops.cefopsBD.domain.escola.Requerimentos.TiposRequerimentos;

public interface RequerimentTypeRepository  extends JpaRepository<TiposRequerimentos,Long>  {

	

}
