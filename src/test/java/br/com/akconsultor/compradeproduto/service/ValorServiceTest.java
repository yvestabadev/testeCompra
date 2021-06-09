package br.com.akconsultor.compradeproduto.service;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ValorServiceTest {
	
	@Mock
	private ValorService service;

	@Test
	void estaPegandoAInformacaoCorretaNaApi() {
		String taxaDeJuros = service.getValorUnico().get(0).getValor();
		assertTrue(taxaDeJuros != null);
	}

}
