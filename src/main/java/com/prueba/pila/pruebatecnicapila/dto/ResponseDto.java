package com.prueba.pila.pruebatecnicapila.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDto {
    private String nroLicencia;
    private LocalDate fecha;
    private String horaInicio;
    private String horaFin;
}
