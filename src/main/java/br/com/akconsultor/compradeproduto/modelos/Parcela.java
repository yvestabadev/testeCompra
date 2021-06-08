package br.com.akconsultor.compradeproduto.modelos;

import java.math.BigDecimal;

public class Parcela {

	private Integer numeroParcela;
	private BigDecimal valor;
	private BigDecimal taxaJurosAoMes;

	public Parcela(Integer numeroParcela, BigDecimal valor, BigDecimal taxaJurosAoMes) {
		this.numeroParcela = numeroParcela;
		this.valor = valor;
		this.taxaJurosAoMes = taxaJurosAoMes;

	}

	public Integer getNumeroParcela() {
		return numeroParcela;
	}

	public void setNumeroParcela(Integer numeroParcela) {
		this.numeroParcela = numeroParcela;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public BigDecimal getTaxaJurosAoMes() {
		return taxaJurosAoMes;
	}

	public void setTaxaJurosAoMes(BigDecimal taxaJurosAoMes) {
		this.taxaJurosAoMes = taxaJurosAoMes;
	}

	@Override
	public String toString() {
		return "[numeroParcela=" + numeroParcela + ", valor=" + valor + ", taxaJurosAoMes="
				+ taxaJurosAoMes + "]";
	}

}
