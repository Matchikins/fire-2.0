package com.br.cefops.cefopsBD.domain.escola;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.crypto.Data;

@Entity
@Table(name = "notas")
public class NotasAlunosData implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
 	private Long Id;
	private Double nota;
	@OneToOne
	@JoinColumn(name = "atividadeId")
	private AtividadesData atividade;
	@OneToOne
	@JoinColumn(name = "alunoId")
	private AlunosData alunoId;
	private Date dataNota;
	
	
	
	
	public AtividadesData getAtividade() {
		return atividade;
	}
	public void setAtividade(AtividadesData atividade) {
		this.atividade = atividade;
	}
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public Double getNota() {
		return nota;
	}
	public void setNota(Double nota) {
		this.nota = nota;
	}

	public AlunosData getAlunoId() {
		return alunoId;
	}
	public void setAlunoId(AlunosData alunoId) {
		this.alunoId = alunoId;
	}
	public Date getDataNota() {
		return dataNota;
	}
	public void setDataNota(Date dataNota) {
		this.dataNota = dataNota;
	}
	@Override
	public int hashCode() {
		return Objects.hash(Id, alunoId, atividade, dataNota, nota);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NotasAlunosData other = (NotasAlunosData) obj;
		return Objects.equals(Id, other.Id) && Objects.equals(alunoId, other.alunoId)
				&& Objects.equals(atividade, other.atividade) && Objects.equals(dataNota, other.dataNota)
				&& Objects.equals(nota, other.nota);
	}
	
	

	
	
 

	
	
	

	

}
