package br.edu.ifpr.pedidos;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PedidoServiceTest {
    @Test
    void deveFecharPedidoDeClienteComumComFreteDoParanaEPagamentoAprovado() {
        Cliente cliente = new Cliente(false, false, 1);
        ItemPedido item = new ItemPedido("LIVRO-JAVA", 10_000, 1, 5, 1_000, false);
        Pedido pedido = new Pedido(List.of(item), "PR", false, null);

        List<Long> cobrancas = new ArrayList<>();
        PedidoService service = new PedidoService(total -> {
            cobrancas.add(total);
            return true;
        });

        ResultadoPedido resultado = service.fechar(pedido, cliente);

        assertAll(
            () -> assertEquals("PAGO", resultado.status()),
            () -> assertEquals(10_000L, resultado.subtotalCentavos()),
            () -> assertEquals(0L, resultado.descontoCentavos()),
            () -> assertEquals(1_200L, resultado.freteCentavos()),
            () -> assertEquals(11_200L, resultado.totalCentavos()),
            () -> assertEquals(List.of(11_200L), cobrancas)
        );
    }

    @Test
    void deveFecharPedidoComumComDescontoEFreteGratisAprovado() {
        Cliente cliente = new Cliente(false, false, 3);
        Pedido pedido = new Pedido(List.of(new ItemPedido("NOTEBOOK", 80_000, 1, 10, 2_000, false)), "SP", false, null);
        PedidoService service = new PedidoService(total -> true);

        ResultadoPedido resultado = service.fechar(pedido, cliente);

        assertAll(
            () -> assertEquals("PAGO", resultado.status()),
            () -> assertEquals(80_000L, resultado.subtotalCentavos()),
            () -> assertEquals(4_000L, resultado.descontoCentavos()),
            () -> assertEquals(0L, resultado.freteCentavos()),
            () -> assertEquals(76_000L, resultado.totalCentavos())
        );
    }

    @Test
    void deveRetornarBloqueadoSemCobrar() {
        Cliente cliente = new Cliente(false, true, 0);
        Pedido pedido = new Pedido(List.of(new ItemPedido("A", 10_000, 1, 5, 500, false)), "PR", false, null);
        PedidoService service = new PedidoService(total -> {
            fail("processador não deve ser chamado");
            return true;
        });

        ResultadoPedido resultado = service.fechar(pedido, cliente);

        assertAll(
            () -> assertEquals("BLOQUEADO", resultado.status()),
            () -> assertEquals(0L, resultado.subtotalCentavos()),
            () -> assertEquals(0L, resultado.freteCentavos()),
            () -> assertEquals(0L, resultado.totalCentavos())
        );
    }

    @Test
    void deveRejeitarPedidoSemItensAtivos() {
        Pedido pedido = new Pedido(List.of(new ItemPedido("A", 10_000, 0, 5, 500, false)), "PR", false, null);
        PedidoService service = new PedidoService(total -> true);

        assertThrows(IllegalArgumentException.class, () -> service.fechar(pedido, new Cliente(false, false, 1)));
    }

    @Test
    void deveRetornarRevistaQuandoRiscoPendente() {
        Cliente cliente = new Cliente(false, false, 0);
        Pedido pedido = new Pedido(List.of(new ItemPedido("A", 50_000, 1, 5, 500, false)), "PR", true, null);
        PedidoService service = new PedidoService(total -> {
            fail("processador não deve ser chamado para risco");
            return true;
        });

        ResultadoPedido resultado = service.fechar(pedido, cliente);

        assertAll(
            () -> assertEquals("REVISAO", resultado.status()),
            () -> assertEquals(50_000L, resultado.subtotalCentavos()),
            () -> assertEquals(2_500L, resultado.descontoCentavos()),
            () -> assertEquals(2_700L, resultado.freteCentavos()),
            () -> assertEquals(50_200L, resultado.totalCentavos())
        );
    }
}
