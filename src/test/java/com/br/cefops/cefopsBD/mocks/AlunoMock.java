package com.br.cefops.cefopsBD.mocks;

import com.br.cefops.cefopsBD.data.vo.v1.AlunosVo;
import com.br.cefops.cefopsBD.domain.escola.AlunosData;

import java.util.ArrayList;
import java.util.List;

public class AlunoMock {
    public AlunosData mockEntity(int i){
        return mockEntity(0);
    }
    public AlunosVo mockVo(int i){
        return mockVo(0);
    }

    public List<AlunosVo> mockVOList() {
        List<AlunosVo> persons = new ArrayList<>();
        for (int i = 0; i < 14; i++) {
            persons.add(mockVo(i));
        }
        return persons;
    }
    private AlunosData mockEntity(Integer number) {
        AlunosData alunos = new AlunosData();
        alunos.setName("Addres Test" + number);
        alunos.setName("First Name Test" + number);
        alunos.setSexo(((number % 2)==0) ? "Male" : "Female");
        alunos.setId("ois"+number);
        alunos.setLastName("Last Name Test" + number);
        return alunos;
    }
    private AlunosVo mockVo(Integer number) {
        AlunosVo alunos = new AlunosVo();
        alunos.setName("Addres Test" + number);
        alunos.setName("First Name Test" + number);
        alunos.setSexo(((number % 2)==0) ? "Male" : "Female");
        alunos.setKey("ois"+number);
        alunos.setLastName("Last Name Test" + number);
        return alunos;
    }
}
