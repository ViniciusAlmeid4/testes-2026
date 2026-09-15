package br.edu.ifpr.pedidos;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PoliticaDescontoTest {
    private final PoliticaDesconto politica = new PoliticaDesconto();

    @Test
    void deveAplicarDescontoVip() {
        long desconto = politica.calcular(new Cliente(true, false, 2), 100_000, null);
        assertEquals(10_000L, desconto);
    }

    @Test
    void deveAplicarDescontoBasicoParaClienteComumAcimaDoLimite() {
        long desconto = politica.calcular(new Cliente(false, false, 2), 50_000, null);
        assertEquals(2_500L, desconto);
    }

    @Test
    void deveManterDescontoZeroQuandoClienteComumNaoAtingeLimite() {
        long desconto = politica.calcular(new Cliente(false, false, 2), 49_999, null);
        assertEquals(0L, desconto);
    }

    @Test
    void deveAplicarCuponsConhecidosERespeitarLimite() {
        long descontoComCupom = politica.calcular(new Cliente(false, false, 0), 200_000, "bemvindo");
        long descontoExtra = politica.calcular(new Cliente(false, false, 1), 200_000, "EXTRA10");

        assertAll(
            () -> assertEquals(12_000L, descontoComCupom),
            () -> assertEquals(30_000L, descontoExtra)
        );
    }

    @Test
    void deveRejeitarCupomDesconhecido() {
        assertThrows(IllegalArgumentException.class, () -> politica.calcular(new Cliente(false, false, 1), 50_000, "XYZ"));
    }
}
