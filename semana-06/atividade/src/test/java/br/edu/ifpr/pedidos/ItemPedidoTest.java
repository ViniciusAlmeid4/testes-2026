package br.edu.ifpr.pedidos;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ItemPedidoTest {
    @Test
    void deveCalcularTotalDoItem() {
        ItemPedido item = new ItemPedido("LIVRO", 10_000, 3, 10, 500, true);

        assertAll(
            () -> assertEquals(30_000L, item.totalCentavos()),
            () -> assertTrue(item.disponivel())
        );
    }

    @Test
    void deveIndicarItemIndisponivelQuandoQuantidadeExcedeEstoque() {
        ItemPedido item = new ItemPedido("CADERNO", 5_000, 5, 4, 200, false);

        assertFalse(item.disponivel());
    }

    @Test
    void deveRejeitarDadosInvalidos() {
        assertAll(
            () -> assertThrows(IllegalArgumentException.class, () -> new ItemPedido("", 10_000, 1, 1, 100, false)),
            () -> assertThrows(IllegalArgumentException.class, () -> new ItemPedido("ABC", 0, 1, 1, 100, false)),
            () -> assertThrows(IllegalArgumentException.class, () -> new ItemPedido("ABC", 10_000, 101, 1, 100, false)),
            () -> assertThrows(IllegalArgumentException.class, () -> new ItemPedido("ABC", 10_000, 1, -1, 100, false)),
            () -> assertThrows(IllegalArgumentException.class, () -> new ItemPedido("ABC", 10_000, 1, 1, 0, false))
        );
    }
}
