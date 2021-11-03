package com.br.cefops.cefopsBD.domain.escola.Curso;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "atividades")
public class AtividadesData implements Serializable {

	private static final long serialVersionUID = -1188373638483796634L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private	Integer Id;
	private String nome;
	private Double nota;
	@ManyToOne
	@JoinColumn(name = "disciplinaId")
	private DisciplinasData disciplina;
	private Date data;


	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Double getNota() {
		return nota;
	}
	public void setNota(Double nota) {
		this.nota = nota;
	}
	public DisciplinasData getDisciplina() {
		return disciplina;
	}
	public void setDisciplina(DisciplinasData disciplina) {
		this.disciplina = disciplina;
	}
	
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	@Override
	public int hashCode() {
		return Objects.hash(Id, data, disciplina, nome, nota);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AtividadesData other = (AtividadesData) obj;
		return Objects.equals(Id, other.Id) && Objects.equals(data, other.data)
				&& Objects.equals(disciplina, other.disciplina) && Objects.equals(nome, other.nome)
				&& Objects.equals(nota, other.nota);
	}
	
	
	
	
	
	
	

}
