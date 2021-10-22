package com.br.cefops.cefopsBD.data.vo.v1;

import java.io.Serializable;
import java.util.Objects;

import org.springframework.hateoas.RepresentationModel;

import com.br.cefops.cefopsBD.domain.escola.AlunosData;

public class EnderecoVo extends RepresentationModel<EnderecoVo> implements Serializable {
	
	private static final long serialVersionUID = 6940227609742292518L;
	private Long id;
	private String cep;
	private String rua;
	private String numero;
	private String complemento;
	private String bairro;
	private String cidade;
	private String estado;
	private String uf;
	private AlunosData alunos;
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
	public AlunosData getAlunos() {
		return alunos;
	}
	public void setAlunos(AlunosData alunos) {
		this.alunos = alunos;
	}
	@Override
	public int hashCode() {
		return Objects.hash(alunos, bairro, cep, cidade, complemento, estado, id, numero, rua, uf);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EnderecoVo other = (EnderecoVo) obj;
		return Objects.equals(alunos, other.alunos) && Objects.equals(bairro, other.bairro)
				&& Objects.equals(cep, other.cep) && Objects.equals(cidade, other.cidade)
				&& Objects.equals(complemento, other.complemento) && Objects.equals(estado, other.estado)
				&& Objects.equals(id, other.id) && Objects.equals(numero, other.numero)
				&& Objects.equals(rua, other.rua) && Objects.equals(uf, other.uf);
	}

	
}
