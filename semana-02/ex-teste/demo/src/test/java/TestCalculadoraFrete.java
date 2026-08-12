import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.CalculadoraFrete;

public class TestCalculadoraFrete {
    
    CalculadoraFrete calculadoraFrete;

    @BeforeEach
    void preparar() {
        calculadoraFrete = new CalculadoraFrete();
    }

    @Test
    public void deveCobrarFrete() {
        assertEquals(20, calculadoraFrete.calcular(0, false));
    }

    @Test
    public void naoDeveCobrarFrete() {
        assertEquals(0, calculadoraFrete.calcular(200, false));
    }
}
