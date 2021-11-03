package com.br.cefops.cefopsBD.data.vo.v1;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.hateoas.RepresentationModel;

import com.br.cefops.cefopsBD.domain.escola.Documentos.Endereço;
import com.br.cefops.cefopsBD.domain.escola.Requerimentos.Requerimentos;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.dozermapper.core.Mapping;


@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@JsonPropertyOrder({ "id", "name", "lastName","cpf","email","teleFone","teleFoneCelular" ,"photo","enabled","requerimentos","endereco"})

public class AlunosVo extends RepresentationModel<AlunosVo> implements Serializable  {

	private static final long serialVersionUID = 1L;
	
	
	
	@Mapping("Id")
	@JsonProperty("id")
	private String key;
	private String Name;
	private	Date dataNanscimento;
	private	String LastName;
	private	String Nacionalidade;
	private	String Email;
	private	String sexo;
	private	String estadoCivil;
	private	String TeleFoneCelular;
	private	String TeleFone;
	private	Boolean enabled;
	private	String photo;
	private List<Requerimentos>  requerimentos ;
	@JsonProperty("endereco")
	private Endereço endereço;


	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
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

	public String getNacionalidade() {
		return Nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		Nacionalidade = nacionalidade;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
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

	public Endereço getEndereço() {
		return endereço;
	}

	public void setEndereço(Endereço endereço) {
		this.endereço = endereço;
	}

}
