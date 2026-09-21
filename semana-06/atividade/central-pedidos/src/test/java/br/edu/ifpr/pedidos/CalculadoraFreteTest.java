package br.edu.ifpr.pedidos;

import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculadoraFreteTest {
    private final CalculadoraFrete frete = new CalculadoraFrete();

    @Test
    void deveCalcularFreteBasePorUf() {
        Pedido pedidoPr = new Pedido(List.of(new ItemPedido("A", 10_000, 1, 5, 1_000, false)), "PR", false, null);
        Pedido pedidoSp = new Pedido(List.of(new ItemPedido("B", 10_000, 1, 5, 1_000, false)), "SP", false, null);
        Pedido pedidoSc = new Pedido(List.of(new ItemPedido("B", 10_000, 1, 5, 1_000, false)), "SC", false, null);

        assertAll(
            () -> assertEquals(1_200L, frete.calcular(pedidoPr, new Cliente(false, false, 1), 10_000)),
            () -> assertEquals(3_000L, frete.calcular(pedidoSc, new Cliente(false, false, 1), 10_000)),
            () -> assertEquals(2_000L, frete.calcular(pedidoSp, new Cliente(false, false, 1), 10_000))
        );
    }

    @Test
    void deveAcrescentarPesoExtraQuandoUltrapassaDoisQuilogramas() {
        Pedido pedido = new Pedido(List.of(new ItemPedido("A", 10_000, 1, 5, 3_500, false)), "PR", false, null);

        assertEquals(1_200L + 300L + 300L, frete.calcular(pedido, new Cliente(false, false, 1), 10_000));
    }

    @Test
    void deveAplicarAdicionaisDeExpressoEFragil() {
        Pedido pedidoExpresso = new Pedido(List.of(new ItemPedido("A", 50_000, 1, 5, 1_000, true)), "PR", true, null);

        assertEquals(3_200L, frete.calcular(pedidoExpresso, new Cliente(false, false, 1), 50_000));
    }

    @Test
    void deveAplicarMeiaTarifaParaVip() {
        Pedido pedido = new Pedido(List.of(new ItemPedido("A", 10_000, 1, 5, 1_000, false)), "RJ", false, null);

        assertEquals(1_000L, frete.calcular(pedido, new Cliente(true, false, 1), 10_000));
    }
}
