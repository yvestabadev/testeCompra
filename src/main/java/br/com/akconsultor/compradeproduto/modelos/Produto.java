package br.com.akconsultor.compradeproduto.modelos;

import java.math.BigDecimal;


public class Produto {
	

	private Long codigo;
	private String nome;
	private BigDecimal valor;
	
	
	
	public Long getId() {
		return codigo;
	}
	public void setId(Long codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	
	
}
