package com.br.cefops.cefopsBD.data.vo.v1;

import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@JsonPropertyOrder({ "id", "name", "grupo","diasPentregar"})
@Data
public class RequerimentsTypysVo implements Serializable {
	private static final long serialVersionUID = 1L;

	private long id;
	private String name;
	private String grupo;
	private Integer diasPentregar;

	
	
	
	

}
