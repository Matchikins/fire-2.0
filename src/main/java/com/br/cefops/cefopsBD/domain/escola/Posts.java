package com.br.cefops.cefopsBD.domain.escola;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Data
@Entity
public class Posts implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	int id;
	String title;
	@Lob
	@Column(columnDefinition="LONGTEXT")
	String poste;
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date datadeCriacao;

}
