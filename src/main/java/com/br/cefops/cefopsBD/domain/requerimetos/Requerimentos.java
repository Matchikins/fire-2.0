package com.br.cefops.cefopsBD.domain.requerimetos;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.br.cefops.cefopsBD.domain.escola.AlunosData;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Requerimentos implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5249726956644179526L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
    @Temporal(TemporalType.DATE)
	private Date Entregue;
	@ManyToOne(cascade = CascadeType.REFRESH)
	  @JoinColumn(name = "aluno_id")
		private AlunosData aluno;
	private Date AbertoEm;
	private Boolean Concluido;
	private String Status;
	private String Responsavel;

	
	
	@ManyToOne()
	  @JoinColumn(name = "tiporequerimento_id")
		private TiposRequerimentos tipo;
	@JsonProperty("tiporequerimento_id")
	private void unpackNested(Long TiposRequerimentos) {
	    this.tipo = new TiposRequerimentos();
	    tipo.setId(TiposRequerimentos);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getEntregue() {
		return Entregue;
	}

	public void setEntregue(Date entregue) {
		Entregue = entregue;
	}

	public AlunosData getAluno() {
		return aluno;
	}

	public void setAluno(AlunosData aluno) {
		this.aluno = aluno;
	}

	public TiposRequerimentos getTipo() {
		return tipo;
	}

	public void setTipo(TiposRequerimentos tipo) {
		this.tipo = tipo;
	}

	public Date getAbertoEm() {
		return AbertoEm;
	}

	public void setAbertoEm(Date abertoEm) {
		AbertoEm = abertoEm;
	}

	public Boolean getConcluido() {
		return Concluido;
	}

	public void setConcluido(Boolean concluido) {
		Concluido = concluido;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public String getResponsavel() {
		return Responsavel;
	}

	public void setResponsavel(String responsavel) {
		Responsavel = responsavel;
	}

	
	
	
		
	
	
	
}
