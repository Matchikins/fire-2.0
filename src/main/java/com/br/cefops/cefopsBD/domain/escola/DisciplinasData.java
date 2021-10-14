package com.br.cefops.cefopsBD.domain.escola;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "disciplinas")
public class DisciplinasData implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer Id;
	String Name;
	@OneToMany()
	private List<AtividadesData>  atividadeId;
	
	

	public List<AtividadesData> getAtividadeId() {
		return atividadeId;
	}
	public void setAtividadeId(List<AtividadesData> atividadeId) {
		this.atividadeId = atividadeId;
	}
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
	@Override
	public int hashCode() {
		return Objects.hash(Id, Name, atividadeId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DisciplinasData other = (DisciplinasData) obj;
		return Objects.equals(Id, other.Id) && Objects.equals(Name, other.Name)
				&& Objects.equals(atividadeId, other.atividadeId);
	}
	
}
