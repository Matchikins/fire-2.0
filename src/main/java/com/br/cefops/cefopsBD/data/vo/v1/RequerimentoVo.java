package com.br.cefops.cefopsBD.data.vo.v1;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

import com.br.cefops.cefopsBD.domain.escola.AlunosData;
import com.br.cefops.cefopsBD.domain.escola.Requerimentos.TiposRequerimentos;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.github.dozermapper.core.Mapping;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Data
@JsonPropertyOrder({ "id","tipo", "aluno","Status","AbertoEm","requerimento","Responsavel","Entregue","Concluido"})
public class RequerimentoVo  implements Serializable {
	private static final long serialVersionUID = 1L;
	@JsonProperty("id")
	private long id;

	private Date Entregue;
	private AlunosData aluno;
	private Date AbertoEm;
	private Boolean Concluido;
	private String Status;
	private String Responsavel;
	private TiposRequerimentos tipo;


}
