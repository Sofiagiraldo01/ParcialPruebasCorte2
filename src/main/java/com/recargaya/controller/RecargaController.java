package com.recargaya.controller;

import com.recargaya.model.RecargaRequest;
import com.recargaya.model.ResultadoRecarga;
import com.recargaya.service.RecargaService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/recargas")
public class RecargaController {

    private final RecargaService service;

    public RecargaController(RecargaService service) {
        this.service = service;
    }

    @PostMapping
    public ResultadoRecarga calcular(
            @RequestBody RecargaRequest request) {

        return service.calcularRecarga(
                request.monto(),
                request.premium()
        );
    }
}