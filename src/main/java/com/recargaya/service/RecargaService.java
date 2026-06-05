package com.recargaya.service;


import com.recargaya.exception.MontoInvalidoException;
import com.recargaya.model.ResultadoRecarga;

public class RecargaService {
    public ResultadoRecarga calcularRecarga(

            double monto,
            boolean premium) {

        validarMonto(monto);
        double bonificacion = 10;

        return new ResultadoRecarga(
                monto,
                bonificacion,
                0
        );


    }

    private void validarMonto(double monto) {

        if (monto < 1000 || monto > 50000) {
            throw new MontoInvalidoException(
                    "Monto fuera de rango"
            );
        }
    }

}
