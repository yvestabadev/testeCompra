package br.com.akconsultor.compradeproduto.dto;

import javax.validation.constraints.NotNull;

import br.com.akconsultor.compradeproduto.modelos.CondicaoPagamento;
import br.com.akconsultor.compradeproduto.modelos.Produto;

public class CompraDTO {
	
	@NotNull
	private Produto produto;
	@NotNull
	private CondicaoPagamento condicaoPagamento;
	
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
