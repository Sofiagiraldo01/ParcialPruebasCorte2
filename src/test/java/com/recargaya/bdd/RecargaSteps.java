package com.recargaya.bdd;

import com.recargaya.exception.MontoInvalidoException;
import com.recargaya.model.ResultadoRecarga;
import com.recargaya.service.RecargaService;
import io.cucumber.java.en.*;

import static org.junit.jupiter.api.Assertions.*;

public class RecargaSteps {

    private double monto;
    private boolean premium;
    private ResultadoRecarga resultado;
    private Exception exception;

    private final RecargaService service =
            new RecargaService();

    @Given("un monto de {double}")
    public void unMonto(double monto) {
        this.monto = monto;
    }

    @Given("un monto invalido de {double}")
    public void unMontoInvalido(double monto) {
        this.monto = monto;
    }

    @And("el usuario es premium")
    public void usuarioPremium() {
        premium = true;
    }

    @And("el usuario no es premium")
    public void usuarioNoPremium() {
        premium = false;
    }

    @And("el usuario es {word}")
    public void usuarioEs(String valor) {
        premium = Boolean.parseBoolean(valor);
    }

    @When("calculo la recarga")
    public void calcularRecarga() {
        resultado =
                service.calcularRecarga(
                        monto,
                        premium
                );
    }

    @When("calculo la recarga invalida")
    public void calcularRecargaInvalida() {

        exception = assertThrows(
                MontoInvalidoException.class,
                () -> service.calcularRecarga(
                        monto,
                        false
                )
        );
    }

    @Then("la bonificacion debe ser {double}")
    public void verificarBonificacion(
            double esperado) {

        assertEquals(
                esperado,
                resultado.porcentajeBonificacion()
        );
    }

    @Then("debe lanzarse una excepcion")
    public void verificarExcepcion() {

        assertNotNull(exception);
    }
}
