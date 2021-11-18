package com.br.cefops.cefopsBD.Controller.GestaoEscolar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class AlunoControllerTest {
@Autowired
AlunoController alunoController;
    @BeforeEach
    void setUp() {
    }

    @Test
    void obterAlunos() {
        var aluno=alunoController.obterAlunos(1,1,"asc");
    }

    @Test
    void obterAlunosPorNome() {
    }

    @Test
    void obterAlunosid() {
    }
}