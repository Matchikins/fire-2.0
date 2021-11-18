package com.br.cefops.cefopsBD.domain.escola;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.*;

import com.br.cefops.cefopsBD.domain.escola.Curso.CursoData;
import com.br.cefops.cefopsBD.domain.escola.Documentos.Endereço;
import com.br.cefops.cefopsBD.domain.escola.Requerimentos.Requerimentos;
import com.br.cefops.cefopsBD.domain.seguranca.User;
import com.br.cefops.cefopsBD.domain.escola.Documentos.DocumentosData;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.CreationTimestamp;


@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "alunos")
public class AlunosData implements Serializable  {
	
	private static final long serialVersionUID = 1L;
	@Id 
	private String Id;
	private String name;
	private Date dataNanscimento;
	private String LastName;
	private	String Nacionalidade;
	private String Email;
	private String sexo;
	private  String cpf;
	private String estadoCivil;
	@Column(columnDefinition = "char(11)")
	private	String TeleFoneCelular;
	@Column(columnDefinition = "char(10)")
	private	String TeleFone;
	@Column(nullable = false, columnDefinition ="tinyint(1) default 1"  )
	private	Boolean enabled;
	@Column(name = "foto_usuario", nullable = true, columnDefinition="varchar(200) default 'https://media.istockphoto.com/photos/astronaut-lying-in-the-meadow-picture-id1304263738?s=612x612'")
	private	String photo;
	@OneToOne(cascade = CascadeType.REMOVE)
	private  Endereço endereço;
	@OneToMany(mappedBy = "aluno")
	private List<Requerimentos>  requerimentos;
	@OneToOne(mappedBy = "alunos")
	private User user;
	@ManyToMany(mappedBy = "aluno",cascade = CascadeType.REMOVE)
	private List<CursoData> cursosId;
	@OneToOne(mappedBy = "alunosId",cascade = CascadeType.REMOVE)
	private DocumentosData documentos;
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date datacadastro;

	public DocumentosData getDocumentos() {
		return documentos;
	}

	public void setDocumentos(DocumentosData documentos) {
		this.documentos = documentos;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Endereço getEndereço() {
		return endereço;
	}

	public void setEndereço(Endereço endereço) {
		this.endereço = endereço;
	}


	public void setRequerimentos(List<Requerimentos> requerimentos) {
		this.requerimentos = requerimentos;
	}



	public void setUser(User user) {
		this.user = user;
	}

	public List<CursoData> getCursosId() {
		return cursosId;
	}

	public void setCursosId(List<CursoData> cursos) {
		this.cursosId = cursos;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof AlunosData)) return false;
		AlunosData that = (AlunosData) o;
		return Objects.equals(Id, that.Id) && Objects.equals(name, that.name) && Objects.equals(dataNanscimento, that.dataNanscimento) && Objects.equals(LastName, that.LastName) && Objects.equals(Nacionalidade, that.Nacionalidade) && Objects.equals(Email, that.Email) && Objects.equals(sexo, that.sexo) && Objects.equals(cpf, that.cpf) && Objects.equals(estadoCivil, that.estadoCivil) && Objects.equals(TeleFoneCelular, that.TeleFoneCelular) && Objects.equals(TeleFone, that.TeleFone) && Objects.equals(enabled, that.enabled) && Objects.equals(photo, that.photo) && Objects.equals(endereço, that.endereço) && Objects.equals(requerimentos, that.requerimentos) && Objects.equals(user, that.user) && Objects.equals(cursosId, that.cursosId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(Id, name, dataNanscimento, LastName, Nacionalidade, Email, sexo, cpf, estadoCivil, TeleFoneCelular, TeleFone, enabled, photo, endereço, requerimentos, user, cursosId);
	}

	public Date getDatacadastro() {
		return datacadastro;
	}

	public void setDatacadastro(Date datacadastro) {
		this.datacadastro = datacadastro;
	}
}
