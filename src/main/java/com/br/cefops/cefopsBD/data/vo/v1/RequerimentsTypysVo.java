package com.br.cefops.cefopsBD.data.vo.v1;

import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@JsonPropertyOrder({ "id", "name", "grupo","diasPentregar"})
public class RequerimentsTypysVo implements Serializable {
	private static final long serialVersionUID = 1L;
	

	private long id;
	private String name;
	private String grupo;
	private Integer diasPentregar;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGrupo() {
		return grupo;
	}
	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}
	public Integer getDiasPentregar() {
		return diasPentregar;
	}
	public void setDiasPentregar(Integer diasPentregar) {
		this.diasPentregar = diasPentregar;
	}
	@Override
	public int hashCode() {
		return Objects.hash(diasPentregar, grupo, id, name);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RequerimentsTypysVo other = (RequerimentsTypysVo) obj;
		return Objects.equals(diasPentregar, other.diasPentregar) && Objects.equals(grupo, other.grupo)
				&& id == other.id && Objects.equals(name, other.name);
	}
	
	
	
	

}
