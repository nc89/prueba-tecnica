package com.prueba.pila.pruebatecnicapila.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Formats {

    public String getFechaFormateada(LocalDateTime fecha) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return fecha.format(formatter);
    }

    public String getHoraFinFormateada(LocalDateTime hora) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        return hora.format(formatter);
    }
}
