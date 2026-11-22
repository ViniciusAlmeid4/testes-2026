package br.edu.ifpr.pedidos;

import java.util.concurrent.atomic.AtomicInteger;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PagamentoServiceTest {
    @Test
    void deveAutorizarPagamentoQuandoProcessadorAprova() {
        AtomicInteger chamadas = new AtomicInteger();
        PagamentoService service = new PagamentoService(total -> {
            chamadas.incrementAndGet();
            assertEquals(42_000L, total);
            return true;
        });

        assertTrue(service.pagar(42_000L, 3));
        assertEquals(1, chamadas.get());
    }

    @Test
    void deveTentarNovamenteQuandoPagamentoEstiverIndisponivel() {
        AtomicInteger chamadas = new AtomicInteger();
        PagamentoService service = new PagamentoService(total -> {
            if (chamadas.incrementAndGet() == 1) throw new IllegalStateException("temporario");
            return true;
        });

        assertTrue(service.pagar(10_000L, 3));
        assertEquals(2, chamadas.get());
    }

    @Test
    void deveRetornarFalseQuandoExcederTentativas() {
        AtomicInteger chamadas = new AtomicInteger();
        PagamentoService service = new PagamentoService(total -> {
            chamadas.incrementAndGet();
            throw new IllegalStateException("temporario");
        });

        assertFalse(service.pagar(10_000L, 3));
        assertEquals(3, chamadas.get());
    }

    @Test
    void devePropagarOutrasExcecoes() {
        PagamentoService service = new PagamentoService(total -> {
            throw new RuntimeException("falha de integracao");
        });

        assertThrows(RuntimeException.class, () -> service.pagar(10_000L, 3));
    }

    @Test
    void deveRejeitarTotalOuTentativasInvalidas() {
        PagamentoService service = new PagamentoService(total -> true);

        assertAll(
            () -> assertThrows(IllegalArgumentException.class, () -> service.pagar(0, 3)),
            () -> assertThrows(IllegalArgumentException.class, () -> service.pagar(10_000L, 0)),
            () -> assertThrows(IllegalArgumentException.class, () -> service.pagar(10_000L, 4))
        );
    }
}
