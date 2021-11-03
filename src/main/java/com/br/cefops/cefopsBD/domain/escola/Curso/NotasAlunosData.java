package com.br.cefops.cefopsBD.domain.escola.Curso;

import com.br.cefops.cefopsBD.domain.escola.AlunosData;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
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
	@Setter
	private AlunosData alunoId;
	private Date dataNota;
	@OneToOne()
	private  DisciplinasData disciplinaId;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}
}
