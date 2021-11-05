package com.br.cefops.cefopsBD.Controller.GestaoEscolar;

import com.br.cefops.cefopsBD.Services.escola.AlunoServices;
import com.br.cefops.cefopsBD.data.vo.v1.AlunosVo;
import com.br.cefops.cefopsBD.repository.GestaoEscolar.AlunoRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest()
@WebAppConfiguration
class AlunoControllerTest {
    @Autowired
    private AlunoController controller;

    @Test
    public void obterAlunos() {

        
    }

    @Test
    void creat() {
    }

    @Test
    void obterAlunosid() {
    }

    @Test
    void eliminarAlunos() {
    }

    @Test
    void alterarAluno() {
    }

    @Test
    void updAlunos() {
    }
}