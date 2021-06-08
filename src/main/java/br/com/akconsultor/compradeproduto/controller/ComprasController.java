package br.com.akconsultor.compradeproduto.controller;


import java.util.List;

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
	public List<Parcela> listaDeParcelas(@RequestBody Produto produto, @RequestBody CondicaoPagamento condicaoPagamento){
		Compra compra = new Compra(produto, condicaoPagamento);
		
		return compra.valorParcelas();
		
	}


}
