package com.recargaya.service;


import com.recargaya.exception.MontoInvalidoException;
import com.recargaya.model.ResultadoRecarga;

public class RecargaService {
    public ResultadoRecarga calcularRecarga(

            double monto,
            boolean premium) {

        validarMonto(monto);

        double bonificacion =
                calcularBonificacion(monto);

        bonificacion =
                aplicarPremium(
                        bonificacion,
                        premium
                );



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

    private double calcularBonificacion(
            double monto) {

        if (monto >= 30000) {
            return 25;
        }

        if (monto >= 10000) {
            return 10;
        }

        return 0;
    }

    private double aplicarPremium(
            double bonificacion,
            boolean premium) {

        if (premium) {
            return bonificacion + 5;
        }

        return bonificacion;
    }


}
