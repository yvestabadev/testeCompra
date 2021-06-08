package br.com.akconsultor.compradeproduto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.akconsultor.compradeproduto.modelos.Compra;
import br.com.akconsultor.compradeproduto.modelos.CondicaoPagamento;
import br.com.akconsultor.compradeproduto.modelos.Parcela;
import br.com.akconsultor.compradeproduto.modelos.Produto;

class CompraTest {

	private Produto produto;
	private CondicaoPagamento condicaoDePagamento;

	@BeforeEach
	void instanciaProdutoECondicao() {
		this.produto = new Produto();
		this.produto.setCodigo(1l);
		this.produto.setNome("Honda Civic 2033");
		this.produto.setValor(new BigDecimal("230000.00"));

		this.condicaoDePagamento = new CondicaoPagamento();
		condicaoDePagamento.setQtdeParcelas(1);
		condicaoDePagamento.setValorEntrada(new BigDecimal(0));
	}

	@Test
	void verSeQtdeDeParcelasEstaoCertas() {
		Compra compra = new Compra(produto, condicaoDePagamento);

		List<Parcela> parcelas = compra.valorParcelas();

		assertEquals(1, parcelas.size());
	}

	@Test
	void valorDasParcelasSemJuros() {
		this.condicaoDePagamento.setQtdeParcelas(2);
		Compra compra = new Compra(produto, condicaoDePagamento);

		List<Parcela> parcelas = compra.valorParcelas();
		
		assertEquals(new BigDecimal("115000.00"), parcelas.get(0).getValor());
		assertEquals(new BigDecimal("115000.00"), parcelas.get(1).getValor());
	}
	
	@Test
	void valorDasParcelasComJuros() {
		this.condicaoDePagamento.setQtdeParcelas(7);
		
		Compra compra = new Compra(produto, condicaoDePagamento);

		List<Parcela> parcelas = compra.valorParcelas();
		
		assertEquals(new BigDecimal("33235.00"), parcelas.get(0).getValor());
		assertEquals(new BigDecimal("33617.20"), parcelas.get(1).getValor());
	}

}
