package com.br.cefops.cefopsBD.domain.escola.Requerimentos;

import com.br.cefops.cefopsBD.domain.escola.AlunosData;
import com.github.dozermapper.core.Mapping;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Data
public class Requerimentos implements Serializable {

	private static final long serialVersionUID = -5249726956644179526L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
    @Temporal(TemporalType.DATE)
	private Date Entregue;
	@ManyToOne()
	@JoinColumn(name = "aluno_id")
	private AlunosData aluno;
	private Date AbertoEm;
	private Boolean Concluido;
	private String Status;
	private String Responsavel;
	@ManyToOne()
	@JoinColumn(name = "tiporequerimento_id")
	@Getter(AccessLevel.NONE)
	private TiposRequerimentos tipo;


}
