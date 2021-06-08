package br.com.akconsultor.compradeproduto.modelos;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class Compra {
	
	private Produto produto;
	private CondicaoPagamento condicaoPagamento;
	private BigDecimal taxaJurosAoMes;
	
	public Compra(Produto produto, CondicaoPagamento condicaoPagamento) {
		
		this.produto = produto;
		this.condicaoPagamento = condicaoPagamento;
		
		if(condicaoPagamento.getQtdeParcelas() > 6) {
			this.taxaJurosAoMes = new BigDecimal("1.0115");
		} else {
			this.taxaJurosAoMes = new BigDecimal(1);
		}
	}
	
	public List<Parcela> valorParcelas(){
		BigDecimal valorRestante = produto.getValor().subtract(condicaoPagamento.getValorEntrada());
		List<Parcela> parcelas = new ArrayList<Parcela>();
		Integer qtdeParcelas = condicaoPagamento.getQtdeParcelas();
		
		for(Integer i = 0; i < qtdeParcelas; i++) {
			valorRestante = valorRestante.multiply(this.taxaJurosAoMes);
			BigDecimal valorParcela = valorRestante
			.divide(new BigDecimal(qtdeParcelas - i), 2, RoundingMode.HALF_EVEN);
			
			valorRestante = valorRestante.subtract(valorParcela);
			
			parcelas.add(new Parcela(i + 1, valorParcela, this.taxaJurosAoMes.subtract(new BigDecimal(1))));
		}
		
		return parcelas;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public CondicaoPagamento getCondicaoPagamento() {
		return condicaoPagamento;
	}

	public void setCondicaoPagamento(CondicaoPagamento condicaoPagamento) {
		this.condicaoPagamento = condicaoPagamento;
	}
	
	
	
	

}
