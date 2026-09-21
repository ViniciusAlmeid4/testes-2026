package br.edu.ifpr.pedidos;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AnaliseRiscoTest {
    private final AnaliseRisco analise = new AnaliseRisco();

    @Test
    void deveRecusarClienteBloqueado() {
        assertEquals("RECUSADO", analise.avaliar(new Cliente(false, true, 3), 100_000, false));
    }

    @Test
    void deveRevisarClienteNovoComPedidoGrandeOuExpresso() {
        assertAll(
            () -> assertEquals("REVISAO", analise.avaliar(new Cliente(false, false, 0), 100_001, false)),
            () -> assertEquals("REVISAO", analise.avaliar(new Cliente(false, false, 0), 80_000, true))
        );
    }

    @Test
    void deveAprovarClienteComComprasAnterioresEValorBaixo() {
        assertEquals("APROVADO", analise.avaliar(new Cliente(false, false, 2), 400_000, false));
    }

    @Test
    void deveRevisarClienteComComprasAnterioresQuandoUltrapassaLimite() {
        assertEquals("REVISAO", analise.avaliar(new Cliente(false, false, 2), 500_001, false));
    }
}
