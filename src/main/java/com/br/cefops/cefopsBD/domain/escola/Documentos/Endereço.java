package com.br.cefops.cefopsBD.domain.escola.Documentos;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.br.cefops.cefopsBD.domain.escola.AlunosData;
@Entity
public class Endereço  implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(columnDefinition = "char(8)")
	private String cep;
	private String rua;
	private String numero;
	private String complemento;
	private String bairro;
	private String cidade;
	private String estado;
	@Column(columnDefinition = "char(2)")
	private String uf;
	@OneToOne(cascade = CascadeType.REMOVE)
	  @JoinColumn(name = "aluno_id")
	private AlunosData alunoId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public void setAlunoId(AlunosData alunoId) {
		this.alunoId = alunoId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Endereço)) return false;
		Endereço endereço = (Endereço) o;
		return Objects.equals(id, endereço.id) && Objects.equals(cep, endereço.cep) && Objects.equals(rua, endereço.rua) && Objects.equals(numero, endereço.numero) && Objects.equals(complemento, endereço.complemento) && Objects.equals(bairro, endereço.bairro) && Objects.equals(cidade, endereço.cidade) && Objects.equals(estado, endereço.estado) && Objects.equals(uf, endereço.uf) && Objects.equals(alunoId, endereço.alunoId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, cep, rua, numero, complemento, bairro, cidade, estado, uf, alunoId);
	}
}
