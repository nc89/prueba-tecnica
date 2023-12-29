package com.prueba.pila.pruebatecnicapila.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDto {
    private String nroLicencia;
    private LocalDate fecha;
    private LocalTime horaInicio;
    private LocalTime horaFin;
}
