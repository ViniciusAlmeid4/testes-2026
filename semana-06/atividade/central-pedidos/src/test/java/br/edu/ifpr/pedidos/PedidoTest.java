package br.edu.ifpr.pedidos;

import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PedidoTest {
    @Test
    void deveSomarSubtotalEConsiderarItensAtivos() {
        ItemPedido ativo = new ItemPedido("A", 10_000, 2, 5, 500, false);
        ItemPedido inativo = new ItemPedido("B", 8_000, 0, 5, 200, false);
        Pedido pedido = new Pedido(List.of(ativo, inativo), "PR", false, null);

        assertAll(
            () -> assertEquals(20_000L, pedido.subtotalCentavos()),
            () -> assertEquals(1_000, pedido.pesoGramas()),
            () -> assertFalse(pedido.temFragil())
        );
    }

    @Test
    void deveDetectarItemFragilEEstoqueInsuficiente() {
        ItemPedido fragil = new ItemPedido("F", 12_000, 1, 0, 300, true);
        Pedido pedido = new Pedido(List.of(fragil), "SP", false, null);

        assertAll(
            () -> assertTrue(pedido.temFragil()),
            () -> assertFalse(pedido.estoqueSuficiente())
        );
    }

    @Test
    void deveRejeitarUfInvalida() {
        assertThrows(IllegalArgumentException.class, () -> new Pedido(List.of(), "P", false, null));
        assertThrows(IllegalArgumentException.class, () -> new Pedido(List.of(), "123", false, null));
    }
}
