package br.com.akconsultor.compradeproduto.controller;


import java.time.LocalDateTime;
import java.time.Period;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.akconsultor.compradeproduto.dto.CompraDTO;
import br.com.akconsultor.compradeproduto.dto.ValorTaxaDTO;
import br.com.akconsultor.compradeproduto.modelos.Compra;
import br.com.akconsultor.compradeproduto.modelos.Parcela;
import br.com.akconsultor.compradeproduto.service.ValorService;


@RestController
@RequestMapping("comprar")
public class ComprasController {
	
	@Autowired
	private ValorService valorService;
	

	
	@PostMapping
	@ResponseBody
	public List<Parcela> listaDeParcelas(@RequestBody @Valid CompraDTO compraDTO){
		Compra compra = new Compra(compraDTO.getProduto(), compraDTO.getCondicaoPagamento(), valorService.getValorUnico().get(0).getValor());
		
		return compra.valorParcelas();
		
	}
	
	@GetMapping("taxa/trintaDias")
	public List<ValorTaxaDTO> mostraUltimosTrintaDias() {
		LocalDateTime dataFinal = LocalDateTime.now();
		LocalDateTime dataInical = dataFinal.minus(Period.ofDays(30));
		
		return valorService.getPorData(dataInical, dataFinal);
	}


}
