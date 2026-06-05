package com.recargaya.service;


import com.recargaya.exception.MontoInvalidoException;
import com.recargaya.model.ResultadoRecarga;

public class RecargaService {
    public ResultadoRecarga calcularRecarga(
            double monto,
            boolean premium) {

        if (monto < 1000) {
            throw new MontoInvalidoException(
                    "Monto fuera de rango"
            );
        }

        return null;
    }
}
