package br.edu.ifpr.pedidos;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ClienteTest {
    @Test
    void deveAceitarClienteValido() {
        assertDoesNotThrow(() -> new Cliente(false, false, 3));
    }

    @Test
    void deveRejeitarHistoricoNegativo() {
        assertThrows(IllegalArgumentException.class, () -> new Cliente(false, false, -1));
    }
}
