package com.br.cefops.cefopsBD.domain.escola.Curso;
import com.br.cefops.cefopsBD.domain.escola.AlunosData;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "curso")
public class CursoData implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;
	private String Name;
	private boolean isOnline;
	@ManyToMany()
	private List<AlunosData> aluno;
	@ManyToMany()
	private List <DisciplinasData> disciplinas;





	
	
	
	
	
	
	
	
}
