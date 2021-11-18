package com.br.cefops.cefopsBD.Services.escola;

import com.br.cefops.cefopsBD.converter.DozerConvert;
import com.br.cefops.cefopsBD.data.vo.v1.RequerimentoVo;
import com.br.cefops.cefopsBD.domain.Exception.ResourceNotFoundException;
import com.br.cefops.cefopsBD.domain.escola.Requerimentos.Requerimentos;
import com.br.cefops.cefopsBD.repository.GestaoEscolar.RequerimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RequerimentoService {
    @Autowired
    RequerimentoRepository repository;

    public List<RequerimentoVo> buscarTodosRequerimentos(){
        var requerimentos= DozerConvert.parseListObjects(
                repository.findAll(),
                RequerimentoVo.class);
        List<RequerimentoVo> req=requerimentos;
        return  requerimentos;
    }

    public RequerimentoVo buscarRequerimentoId(Long id){
        var requerimento=DozerConvert.parseObject(
                repository.findById(id),
                RequerimentoVo.class);
        return requerimento;
    }
    public RequerimentoVo novoRequerimento(RequerimentoVo requerimentoVo){
        var novoRequerimento=DozerConvert.parseObject(
                requerimentoVo,
                Requerimentos.class);
        var requerimento=repository.save(
                novoRequerimento);
        return requerimentoVo ;
    }
    public RequerimentoVo alterarRequerimento(RequerimentoVo requerimentoVo){
        var novoRequerimento=DozerConvert.parseObject(
                requerimentoVo,
                Requerimentos.class);
        var requerimento=repository.save(
                novoRequerimento);
        return requerimentoVo ;
    }
    public ResponseEntity deletarRequerimento(Long id){
        var requerimento=repository.findById(id);
        if (requerimento.isPresent()){
            repository.deleteById(id);
            ResponseEntity.ok();
        }throw new ResourceNotFoundException("Registro não encontrado");
    }

    public RequerimentoVo dadosFiltrados(RequerimentoVo requerimento) {
        requerimento.getId();
        requerimento.getAluno().getId();
        requerimento.getAluno().getEmail();
        requerimento.getAluno().getName();
        requerimento.getAluno().getLastName();
        requerimento.getAbertoEm();
        requerimento.getConcluido();
        return requerimento;
    }
}
