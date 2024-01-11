package school.sptech.marketplaceresumido.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculadoraMercadoriaServiceTest {
    @Test
    @DisplayName("Deve retornar valor correto ao calcular")
    void deveRetornarValorCorretoAoCalcular() {
        CalculadoraMercadoriaService calculadora = new CalculadoraMercadoriaService();
        assertEquals(18.0, calculadora.calculaICMS(100.0));
    }

    @Test
    @DisplayName("Deve retornar IllegalArgumentException ao passar valor nulo")
    void deveRetornarIllegalArgumentExceptionAoPassarValorNulo() {
        CalculadoraMercadoriaService calculadora = new CalculadoraMercadoriaService();
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> calculadora.calculaICMS(null));

        assertEquals("Valor da mercadoria não pode ser nulo", exception.getMessage());
    }

    @Test
    @DisplayName("Deve retornar IllegalArgumentException ao passar valor zero")
    void deveRetornarIllegalArgumentExceptionAoPassarValorZero() {
        CalculadoraMercadoriaService calculadora = new CalculadoraMercadoriaService();
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> calculadora.calculaICMS(0.0));
        assertEquals("Valor da mercadoria não pode ser zero", exception.getMessage());
    }

    @Test
    @DisplayName("Deve retornar IllegalArgumentException ao passar valor negativo")
    void deveRetornarIllegalArgumentExceptionAoPassarValorNegativo() {
        CalculadoraMercadoriaService calculadora = new CalculadoraMercadoriaService();
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> calculadora.calculaICMS(-100.0));
        assertEquals("Valor da mercadoria não pode ser negativo", exception.getMessage());
    }


}