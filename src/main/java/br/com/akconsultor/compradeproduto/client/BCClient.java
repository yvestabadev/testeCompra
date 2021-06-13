package br.com.akconsultor.compradeproduto.client;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.akconsultor.compradeproduto.dto.ValorTaxaDTO;

@FeignClient(name = "BCService", url = "https://api.bcb.gov.br/")
public interface BCClient {
	
	@GetMapping(value = "/dados/serie/bcdata.sgs.11/dados/ultimos/1?formato=json")
	public List<ValorTaxaDTO> getValorUnico();
	
	@GetMapping(value = "/dados/serie/bcdata.sgs.11/dados?formato=json&dataInicial={dataInicial}&dataFinal={dataFinal}")
	public List<ValorTaxaDTO> getPorData(@PathVariable @DateTimeFormat(pattern = "dd.MM.yyyy") LocalDateTime dataInicial,
			@PathVariable @DateTimeFormat(pattern = "dd.MM.yyyy") LocalDateTime dataFinal);

}
