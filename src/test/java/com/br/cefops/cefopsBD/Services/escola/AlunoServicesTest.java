package com.br.cefops.cefopsBD.Services.escola;

import com.br.cefops.cefopsBD.mocks.AlunoMock;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;

import static org.junit.jupiter.api.Assertions.*;

class AlunoServicesTest {

    AlunoMock inputObject;

    @Before
    public void setUp() {
        inputObject = new AlunoMock();
    }

    @Test
    void creatAluno() {
    }

    @Test
    void findAlunosByName() {
    }

    @Test
    void findAlunos() {
    }

    @Test
    void findAlunosID() {
    }

    @Test
    void updateAluno() {
    }

    @Test
    void delete() {
    }
}