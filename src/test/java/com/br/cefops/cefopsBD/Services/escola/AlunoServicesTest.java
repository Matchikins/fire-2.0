package com.br.cefops.cefopsBD.Services.escola;

import com.br.cefops.cefopsBD.data.vo.v1.AlunosVo;
import com.br.cefops.cefopsBD.domain.escola.AlunosData;
import com.br.cefops.cefopsBD.repository.GestaoEscolar.AlunoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@RunWith(SpringRunner.class)

class AlunoServicesTest {

   @Autowired
    AlunoServices services;

    @Test
    void criarAluno() {
        var entity= new AlunosVo();
        entity.setName("Virgulino");
        entity.setLastName("Ferreira da Silva");
        entity.setKey("123456789101");
        entity.setEmail("emisondias1@gmail.com");
        services.creatAluno(entity);
        assertEquals(entity,services.creatAluno(entity));

    }

    @Test
    void buscarTodosAlunos() {




    }

    @Test
    void ErrorfindAlunosID() {


    }

    @Test
    void updateAluno() {
    }

    @Test
    void delete() {
    }
}