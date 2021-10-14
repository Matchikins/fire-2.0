package com.br.cefops.cefopsBD.domain.escola;
import java.io.Serializable;
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
    @JoinColumn(name = "endereço_id", referencedColumnName = "id")
	private Endereço endereço;
	
	
	public Boolean getEnable() {
		return enabled;
	}
	public void setEnable(Boolean enable) {
		this.enabled = enable;
	}
	String  Cpf;
	public String getCpf() {
		return Cpf;
	}
	public void setCpf(String cpf) {
		Cpf = cpf;
	}




	

	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}


	

	
	
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
	@Override
	public int hashCode() {
		return Objects.hash(Cpf, Email, Id, LastName, Name, enabled, photo, requerimentos, user);
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
		return Objects.equals(Cpf, other.Cpf) && Objects.equals(Email, other.Email) && Objects.equals(Id, other.Id)
				&& Objects.equals(LastName, other.LastName) && Objects.equals(Name, other.Name)
				&& Objects.equals(enabled, other.enabled) && Objects.equals(photo, other.photo)
				&& Objects.equals(requerimentos, other.requerimentos) && Objects.equals(user, other.user);
	}
	



}
