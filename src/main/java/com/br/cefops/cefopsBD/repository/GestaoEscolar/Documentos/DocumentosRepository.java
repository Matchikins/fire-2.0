package com.br.cefops.cefopsBD.repository.GestaoEscolar.Documentos;

import com.br.cefops.cefopsBD.domain.escola.Documentos.DocumentosData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentosRepository  extends JpaRepository<DocumentosData,Long> {
}
