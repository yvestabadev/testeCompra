package br.com.akconsultor.compradeproduto.service;

import java.time.LocalDateTime;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.akconsultor.compradeproduto.client.BCClient;
import br.com.akconsultor.compradeproduto.dto.CompraDTO;
import br.com.akconsultor.compradeproduto.dto.ValorTaxaDTO;
import br.com.akconsultor.compradeproduto.modelos.Compra;
import br.com.akconsultor.compradeproduto.modelos.Parcela;

@Service
public class ValorService {

	@Autowired
	BCClient bcClient;

	public List<ValorTaxaDTO> getPorData(LocalDateTime dataInicial, LocalDateTime dataFinal) {

		return bcClient.getPorData(dataInicial, dataFinal);
	}

	public List<Parcela> getValorParcela(@Valid CompraDTO compraDTO) {
		Compra compra = new Compra(compraDTO.getProduto(), compraDTO.getCondicaoPagamento(), bcClient.getValorUnico().get(0).getValor());
		
		return  compra.valorParcelas();
	}

}
