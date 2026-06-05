package com.recargaya.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Map;

public class GlobalExceptionHandler{
@ExceptionHandler(MontoInvalidoException.class)
public ResponseEntity<Map<String,String>>
manejarMontoInvalido(MontoInvalidoException ex){

    return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(
                    Map.of(
                            "error",
                            ex.getMessage()
                    )
            );
}
}