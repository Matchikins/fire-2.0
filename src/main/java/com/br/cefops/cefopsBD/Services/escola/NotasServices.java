package com.br.cefops.cefopsBD.Services.escola;

import com.br.cefops.cefopsBD.domain.escola.Curso.NotasAlunosData;
import com.br.cefops.cefopsBD.repository.GestaoEscolar.NotasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotasServices {
    @Autowired
    NotasRepository repository;


    public List<NotasAlunosData> EncontrarNotasPorID(String id) {
        return repository.findAllByAlunoId(id);
    }

    public  NotasAlunosData SetarNota(NotasAlunosData notas){
        return repository.save(notas);
    }

    public  NotasAlunosData AtualizarNotas(NotasAlunosData notas){
         return   repository.save(notas);

    }

}
