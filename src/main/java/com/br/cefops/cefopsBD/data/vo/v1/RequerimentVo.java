package com.br.cefops.cefopsBD.data.vo.v1;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import org.springframework.hateoas.RepresentationModel;

import com.br.cefops.cefopsBD.domain.escola.AlunosData;
import com.br.cefops.cefopsBD.domain.escola.Requerimentos.TiposRequerimentos;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.github.dozermapper.core.Mapping;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@JsonPropertyOrder({ "id", "aluno", "tipo","Status","AbertoEm","requerimento","Responsavel","Entregue","Concluido"})
public class RequerimentVo  extends RepresentationModel<RequerimentVo> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Mapping("id")
	private long key;
	private Date Entregue;
	private AlunosData aluno;
	private Date AbertoEm;
	private Boolean Concluido;
	private String Status;
	private String Responsavel;
	private TiposRequerimentos tipo;

	public long getKey() {
		return key;
	}

	public void setKey(long key) {
		this.key = key;
	}

	public Date getEntregue() {
		return Entregue;
	}

	public void setEntregue(Date entregue) {
		Entregue = entregue;
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

	public void setAluno(AlunosData aluno) {
		this.aluno = aluno;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof RequerimentVo)) return false;
		if (!super.equals(o)) return false;
		RequerimentVo that = (RequerimentVo) o;
		return key == that.key && Objects.equals(Entregue, that.Entregue) && Objects.equals(aluno, that.aluno) && Objects.equals(AbertoEm, that.AbertoEm) && Objects.equals(Concluido, that.Concluido) && Objects.equals(Status, that.Status) && Objects.equals(Responsavel, that.Responsavel) && Objects.equals(tipo, that.tipo);
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), key, Entregue, aluno, AbertoEm, Concluido, Status, Responsavel, tipo);
	}
}
