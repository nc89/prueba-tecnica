package com.prueba.pila.pruebatecnicapila.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDto {
    private String nroLicencia;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;
}
