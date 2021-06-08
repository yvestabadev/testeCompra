package br.com.akconsultor.compradeproduto.modelos;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

public class CondicaoPagamento {
	
	@NotNull 
	private BigDecimal valorEntrada;
	
	@NotNull 
	private Integer qtdeParcelas;
	
	
	public BigDecimal getValorEntrada() {
		return valorEntrada;
	}
	public void setValorEntrada(BigDecimal valorEntrada) {
		this.valorEntrada = valorEntrada;
	}
	public Integer getQtdeParcelas() {
		return qtdeParcelas;
	}
	public void setQtdeParcelas(Integer qtdeParcelas) {
		this.qtdeParcelas = qtdeParcelas;
	}

}
