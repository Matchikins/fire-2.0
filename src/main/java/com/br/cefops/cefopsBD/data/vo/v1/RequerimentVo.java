package com.br.cefops.cefopsBD.data.vo.v1;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.br.cefops.cefopsBD.domain.Alunos;
import com.br.cefops.cefopsBD.domain.requerimetos.Requerimentos;
import com.br.cefops.cefopsBD.domain.requerimetos.TiposRequerimentos;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@JsonPropertyOrder({ "id", "aluno", "tipo","Status","AbertoEm","requerimento","Responsavel","Entregue","Concluido"})
public class RequerimentVo  implements Serializable {
	private static final long serialVersionUID = 1L;

	
	private long id;
	private Date Entregue;
	private Alunos aluno;
	private Date AbertoEm;
	private Boolean Concluido;
	private String Status;
	private String Responsavel;
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
	public Alunos getAluno() {
		return aluno;
	}
	public void setAluno(Alunos aluno) {
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
	public int hashCode() {
		return Objects.hash(AbertoEm, Concluido, Entregue, Responsavel, Status, aluno, id, tipo);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RequerimentVo other = (RequerimentVo) obj;
		return Objects.equals(AbertoEm, other.AbertoEm) && Objects.equals(Concluido, other.Concluido)
				&& Objects.equals(Entregue, other.Entregue) && Objects.equals(Responsavel, other.Responsavel)
				&& Objects.equals(Status, other.Status) && Objects.equals(aluno, other.aluno) && id == other.id
				&& Objects.equals(tipo, other.tipo);
	}

	
	

	

	

}
