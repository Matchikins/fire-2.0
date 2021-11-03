package com.br.cefops.cefopsBD.domain.escola.Requerimentos;

import com.br.cefops.cefopsBD.domain.escola.AlunosData;

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
	private TiposRequerimentos tipo;


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



	public void setAluno(AlunosData aluno) {
		this.aluno = aluno;
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

	public TiposRequerimentos getTipo() {
		return tipo;
	}

	public void setTipo(TiposRequerimentos tipo) {
		this.tipo = tipo;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Requerimentos)) return false;
		Requerimentos that = (Requerimentos) o;
		return id == that.id && Objects.equals(Entregue, that.Entregue) && Objects.equals(aluno, that.aluno) && Objects.equals(AbertoEm, that.AbertoEm) && Objects.equals(Concluido, that.Concluido) && Objects.equals(Status, that.Status) && Objects.equals(Responsavel, that.Responsavel) && Objects.equals(tipo, that.tipo);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, Entregue, aluno, AbertoEm, Concluido, Status, Responsavel, tipo);
	}
}
