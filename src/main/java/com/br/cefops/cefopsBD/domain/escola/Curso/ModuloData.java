package com.br.cefops.cefopsBD.domain.escola.Curso;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Modulos")
public class ModuloData implements  Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;
	private String Name;
	@OneToMany
	private List<DisciplinasData>  disciplinas;
	@ManyToOne
	private CursoData curso;
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public List<DisciplinasData> getDisciplinas() {
		return disciplinas;
	}
	public void setDisciplinas(List<DisciplinasData> disciplinas) {
		this.disciplinas = disciplinas;
	}
	public CursoData getCurso() {
		return curso;
	}
	public void setCurso(CursoData curso) {
		this.curso = curso;
	}
	@Override
	public int hashCode() {
		return Objects.hash(Id, Name, curso, disciplinas);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ModuloData other = (ModuloData) obj;
		return Objects.equals(Id, other.Id) && Objects.equals(Name, other.Name) && Objects.equals(curso, other.curso)
				&& Objects.equals(disciplinas, other.disciplinas);
	}

	
	
	
	
	
	
	
	
	

}
