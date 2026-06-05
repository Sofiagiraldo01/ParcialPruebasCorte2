package com.recargaya.controller;

import com.recargaya.model.RecargaRequest;
import com.recargaya.model.ResultadoRecarga;
import com.recargaya.service.RecargaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/recargas")
@RequiredArgsConstructor
public class RecargaController {
    private final RecargaService service;

    @PostMapping
    public ResultadoRecarga calcular(
            @RequestBody RecargaRequest request) {

        return service.calcularRecarga(
                request.monto(),
                request.premium()
        );
    }
}
