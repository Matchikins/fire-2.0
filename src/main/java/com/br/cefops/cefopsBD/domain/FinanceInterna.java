package com.br.cefops.cefopsBD.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "finança_interna")
public class FinanceInterna  implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String Descricao;
	private double Valor;
	private Boolean Pago;
	private Boolean PagoNaData;
	private Date DataVencimento;
	private Date DataPagamento;
	private int Parcelas;
	private String parcelaAtual;
	@Column(name = "unidade")
	private String unidade;
	@Column(name = "meios_pagamento")
	private String meioPagamento;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDescricao() {
		return Descricao;
	}
	public void setDescricao(String descricao) {
		Descricao = descricao;
	}
	public double getValor() {
		return Valor;
	}
	public void setValor(double valor) {
		Valor = valor;
	}
	public Boolean getPago() {
		return Pago;
	}
	public void setPago(Boolean pago) {
		Pago = pago;
	}
	public Boolean getPagoNaData() {
		return PagoNaData;
	}
	public void setPagoNaData(Boolean pagoNaData) {
		PagoNaData = pagoNaData;
	}
	public Date getDataVencimento() {
		return DataVencimento;
	}
	public void setDataVencimento(Date dataVencimento) {
		DataVencimento = dataVencimento;
	}
	public Date getDataPagamento() {
		return DataPagamento;
	}
	public void setDataPagamento(Date dataPagamento) {
		DataPagamento = dataPagamento;
	}
	public int getParcelas() {
		return Parcelas;
	}
	public void setParcelas(int parcelas) {
		Parcelas = parcelas;
	}
	public String getParcelaAtual() {
		return parcelaAtual;
	}
	public void setParcelaAtual(String parcelaAtual) {
		this.parcelaAtual = parcelaAtual;
	}
	public String getUnidade() {
		return unidade;
	}
	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}
	public String getMeioPagamento() {
		return meioPagamento;
	}
	public void setMeioPagamento(String meioPagamento) {
		this.meioPagamento = meioPagamento;
	}
	@Override
	public int hashCode() {
		return Objects.hash(DataPagamento, DataVencimento, Descricao, Pago, PagoNaData, Parcelas, Valor, id,
				meioPagamento, parcelaAtual, unidade);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FinanceInterna other = (FinanceInterna) obj;
		return Objects.equals(DataPagamento, other.DataPagamento)
				&& Objects.equals(DataVencimento, other.DataVencimento) && Objects.equals(Descricao, other.Descricao)
				&& Objects.equals(Pago, other.Pago) && Objects.equals(PagoNaData, other.PagoNaData)
				&& Parcelas == other.Parcelas && Double.doubleToLongBits(Valor) == Double.doubleToLongBits(other.Valor)
				&& id == other.id && Objects.equals(meioPagamento, other.meioPagamento)
				&& Objects.equals(parcelaAtual, other.parcelaAtual) && Objects.equals(unidade, other.unidade);
	}
	
	
	


	
	

	
	

}
