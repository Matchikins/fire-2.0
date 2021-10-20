package com.br.cefops.cefopsBD.data.vo.v1;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import com.br.cefops.cefopsBD.domain.requerimetos.Requerimentos;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@JsonPropertyOrder({ "id", "name", "lastName","cpf","email","photo","requerimentos","enabled"})
public class AlunosVo implements Serializable  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	String Id;
	String Name;
	String LastName;
	String Email;
	Boolean enabled;
	String photo;
	private List<Requerimentos>  requerimentos;
	String  Cpf;
	
	
	
	
	public Boolean getEnable() {
		return enabled;
	}
	public void setEnable(Boolean enable) {
		this.enabled = enable;
	}
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
		return Objects.hash(Cpf, Email, Id, LastName, Name, enabled, photo, requerimentos);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AlunosVo other = (AlunosVo) obj;
		return Objects.equals(Cpf, other.Cpf) && Objects.equals(Email, other.Email) && Objects.equals(Id, other.Id)
				&& Objects.equals(LastName, other.LastName) && Objects.equals(Name, other.Name)
				&& Objects.equals(enabled, other.enabled) && Objects.equals(photo, other.photo)
				&& Objects.equals(requerimentos, other.requerimentos);
	}
	

}
