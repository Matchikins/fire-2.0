package com.br.cefops.cefopsBD.Services.escola;

import com.br.cefops.cefopsBD.converter.DozerConvert;
import com.br.cefops.cefopsBD.data.vo.v1.RequerimentoVo;
import com.br.cefops.cefopsBD.data.vo.v1.RequerimentsTypysVo;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@RunWith(SpringRunner.class)
@WebAppConfiguration
class RequerimentoServiceTest {
    @Autowired
    RequerimentoService service;
    @Test
    void buscarTodosRequerimentos() {
      List<RequerimentoVo> requerimentoVo=service.buscarTodosRequerimentos();
      var tamanho=requerimentoVo.size();
      var naonulo=false;
      if (tamanho >=1){
          naonulo=true;
      }
      assertEquals(naonulo,tamanho>=1);
      assertEquals("Geremias",requerimentoVo.get(0).getResponsavel());

    }

    @Test
    void buscarRequerimentoId() {
        var requerimento=service.buscarRequerimentoId( 1L);
        System.out.println(requerimento);
        assertEquals(0,requerimento.getId());
        assertEquals("Geremias",requerimento.getResponsavel());
                ;
    }





}