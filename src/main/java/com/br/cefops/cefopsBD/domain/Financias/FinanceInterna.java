package com.br.cefops.cefopsBD.domain.Financias;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.*;

@Entity
@Data
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
	@Column(name = "valor_pago")
	private Double valorPago;
	private String status;
	@Column(columnDefinition ="tinyint(1) default 0" )
	private Boolean aberturaCaiaxa;
	@Column(columnDefinition ="tinyint(1) default 0" )
	private Boolean fechamentoCaixa;
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date datadeCriacao;



}
