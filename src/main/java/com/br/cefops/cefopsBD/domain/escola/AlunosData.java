package com.br.cefops.cefopsBD.domain.escola;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.br.cefops.cefopsBD.domain.EnderecoV2;
import com.br.cefops.cefopsBD.domain.Endereço;
import com.br.cefops.cefopsBD.domain.User;
import com.br.cefops.cefopsBD.domain.requerimetos.Requerimentos;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "alunos")
@JsonPropertyOrder({ "id", "name", "lastName","cpf","email","photo","requerimentos","enabled"})
public class AlunosData implements Serializable  {
	
	private static final long serialVersionUID = 1L;
	@Id 
	String Id;
	String Name;
	String EstadoNatal;
	String Naturalidade;
	Date dataNanscimento;
	String LastName;
	String Email;
	@Column(columnDefinition = "char(11)")
	String TeleFoneCelular;
	@Column(columnDefinition = "char(10)")
	String TeleFone;
	@Column(nullable = false, columnDefinition ="tinyint(1) default 1"  )
	Boolean enabled;
	@Column(name = "foto_usuario", nullable = true, columnDefinition="varchar(200) default 'https://media.istockphoto.com/photos/astronaut-lying-in-the-meadow-picture-id1304263738?s=612x612'")
	String photo;
	@OneToMany(mappedBy = "aluno")
	private List<Requerimentos>  requerimentos;
	@OneToOne(mappedBy = "alunos")
	private User user;
	@OneToOne(cascade = CascadeType.REMOVE)
	private Endereço endereço;
	@OneToOne(cascade = CascadeType.ALL,mappedBy = "aluno")
	private EnderecoV2 enderecoV2 ;
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getEstadoNatal() {
		return EstadoNatal;
	}
	public void setEstadoNatal(String estadoNatal) {
		EstadoNatal = estadoNatal;
	}
	public String getNaturalidade() {
		return Naturalidade;
	}
	public void setNaturalidade(String naturalidade) {
		Naturalidade = naturalidade;
	}
	public Date getDataNanscimento() {
		return dataNanscimento;
	}
	public void setDataNanscimento(Date dataNanscimento) {
		this.dataNanscimento = dataNanscimento;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getTeleFoneCelular() {
		return TeleFoneCelular;
	}
	public void setTeleFoneCelular(String teleFoneCelular) {
		TeleFoneCelular = teleFoneCelular;
	}
	public String getTeleFone() {
		return TeleFone;
	}
	public void setTeleFone(String teleFone) {
		TeleFone = teleFone;
	}
	public Boolean getEnabled() {
		return enabled;
	}
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public List<Requerimentos> getRequerimentos() {
		return requerimentos;
	}
	public void setRequerimentos(List<Requerimentos> requerimentos) {
		this.requerimentos = requerimentos;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Endereço getEndereço() {
		return endereço;
	}
	public void setEndereço(Endereço endereço) {
		this.endereço = endereço;
	}
	public EnderecoV2 getEnderecoV2() {
		return enderecoV2;
	}
	public void setEnderecoV2(EnderecoV2 enderecoV2) {
		this.enderecoV2 = enderecoV2;
	}
	@Override
	public int hashCode() {
		return Objects.hash(Email, EstadoNatal, Id, LastName, Name, Naturalidade, TeleFone, TeleFoneCelular,
				dataNanscimento, enabled, enderecoV2, endereço, photo, requerimentos, user);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AlunosData other = (AlunosData) obj;
		return Objects.equals(Email, other.Email) && Objects.equals(EstadoNatal, other.EstadoNatal)
				&& Objects.equals(Id, other.Id) && Objects.equals(LastName, other.LastName)
				&& Objects.equals(Name, other.Name) && Objects.equals(Naturalidade, other.Naturalidade)
				&& Objects.equals(TeleFone, other.TeleFone) && Objects.equals(TeleFoneCelular, other.TeleFoneCelular)
				&& Objects.equals(dataNanscimento, other.dataNanscimento) && Objects.equals(enabled, other.enabled)
				&& Objects.equals(enderecoV2, other.enderecoV2) && Objects.equals(endereço, other.endereço)
				&& Objects.equals(photo, other.photo) && Objects.equals(requerimentos, other.requerimentos)
				&& Objects.equals(user, other.user);
	}
	
	
	
	



}
