package com.br.cefops.cefopsBD.domain.escola.Curso;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.*;

@Entity
@Table(name = "disciplinas")
public class DisciplinasData implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;
	private String Name;
    @Column(columnDefinition = "integer default 0")
	private Integer cargaTeoria;
    @Column(columnDefinition = "integer default 0")
	private Integer cargaEstagio;
    @Column(columnDefinition="integer default 0")
	private Integer cargaTotal;
    private Boolean requisitoEstagio;
	@OneToMany()
	private List<AtividadesData>  atividadeId;
	@ManyToMany(mappedBy = "disciplinas")
	private List<CursoData> curso;
	
	

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
	public Integer getCargaTeoria() {
		return cargaTeoria;
	}
	public void setCargaTeoria(Integer cargaTeoria) {
		this.cargaTeoria = cargaTeoria;
	}
	public Integer getCargaEstagio() {
		return cargaEstagio;
	}
	public void setCargaEstagio(Integer cargaEstagio) {
		this.cargaEstagio = cargaEstagio;
	}
	public Integer getCargaTotal() {
		return cargaTotal;
	}
	public void setCargaTotal(Integer cargaTotal) {
		this.cargaTotal = cargaTotal;
	}
	
	
	public Boolean getRequisitoEstagio() {
		return requisitoEstagio;
	}
	public void setRequisitoEstagio(Boolean requisitoEstagio) {
		this.requisitoEstagio = requisitoEstagio;
	}
	@Override
	public int hashCode() {
		return Objects.hash(Id, Name, atividadeId, cargaEstagio, cargaTeoria, cargaTotal, requisitoEstagio);
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
				&& Objects.equals(atividadeId, other.atividadeId) && Objects.equals(cargaEstagio, other.cargaEstagio)
				&& Objects.equals(cargaTeoria, other.cargaTeoria) && Objects.equals(cargaTotal, other.cargaTotal)
				&& Objects.equals(requisitoEstagio, other.requisitoEstagio);
	}
	
}
