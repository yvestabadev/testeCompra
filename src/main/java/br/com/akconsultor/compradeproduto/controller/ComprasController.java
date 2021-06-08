package br.com.akconsultor.compradeproduto.controller;


import java.math.BigDecimal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.akconsultor.compradeproduto.modelos.Compra;
import br.com.akconsultor.compradeproduto.modelos.CondicaoPagamento;
import br.com.akconsultor.compradeproduto.modelos.Parcela;
import br.com.akconsultor.compradeproduto.modelos.Produto;


@RestController
@RequestMapping("comprar")
public class ComprasController {
	
	@PostMapping
	@ResponseBody
	public List<Parcela> listaDeParcelas(@RequestBody @Valid Produto produto, @RequestBody @Valid CondicaoPagamento condicaoPagamento){
		Compra compra = new Compra(produto, condicaoPagamento);
		
		return compra.valorParcelas();
		
	}
	
	@GetMapping
	@ResponseBody
	public Produto mostraCondicao() {
		Produto produto = new Produto();
		produto.setCodigo(12l);
		produto.setNome("honda civic 2033");
		produto.setValor(new BigDecimal("230000.00"));
		
		return produto;
	}


}
