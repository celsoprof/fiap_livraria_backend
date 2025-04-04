package br.dev.celso.livraria.controller.exception;

import lombok.*;

import java.time.Instant;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ErrorResponse {

    private Instant timestamp;
    private Integer status;
    private String error;
    private String path;

}
