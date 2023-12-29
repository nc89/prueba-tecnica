package com.prueba.pila.pruebatecnicapila.controller;

import com.prueba.pila.pruebatecnicapila.dto.ResponseDto;
import com.prueba.pila.pruebatecnicapila.services.CitaService;
import com.prueba.pila.pruebatecnicapila.services.MedicamentoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/v1/es/cita")
@CrossOrigin("*")
public class CitaController {

    @Autowired
    private CitaService citaService;

    @Operation(summary = "Lista la agenda de citas de pacientes de un\n" +
            "medico por fecha y hora, - Como entrada se debe enviar la fecha , hora de inicio y hora de salida - Como\n" +
            "respuesta debe retornar los nombres y apellidos de los pacientes")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error"),})
    @PostMapping(value = "/pacientes-medico")
    public ResponseEntity<?> pacientesMedico(@RequestBody ResponseDto dto) {
        var pacientes= citaService.obtenerCitasPorFechaYHora(dto);
        if(pacientes == null){
            return new ResponseEntity<>("{}", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(pacientes, HttpStatus.OK);
    }
}
