package com.recargaya.unit;
import com.recargaya.exception.MontoInvalidoException;
import com.recargaya.service.RecargaService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RecargaServiceTest {

    private final RecargaService service = new RecargaService();

    @Test
    void debeRechazarMontosMenoresA1000() {
        assertThrows(
                MontoInvalidoException.class,
                () -> service.calcularRecarga(999, false)
        );
    }
}
