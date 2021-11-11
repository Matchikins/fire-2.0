package com.br.cefops.cefopsBD.data.vo.v1;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class FinancesInternaVo implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private long id;
	private String Descricao;
	private double Valor;
	private Boolean Pago;
	private Boolean PagoNaData;
	private Date DataVencimento;
	private Date DataPagamento;
	private int Parcelas;
	private String parcelaAtual;
	private String unidade;
	private String meioPagamento;
	private Double valorPago;
	private String status;
	private Boolean aberturaCaiaxa;
	private Boolean fechamentoCaixa;
	private Date datadeCriacao;

}
