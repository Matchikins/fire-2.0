package com.br.cefops.cefopsBD.domain.escola.Requerimentos;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class TiposRequerimentos {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	private String grupo;
	private Integer diasPentregar;
	
	
	
	
	
}
