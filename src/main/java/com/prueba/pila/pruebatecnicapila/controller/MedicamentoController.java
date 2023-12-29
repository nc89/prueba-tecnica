package com.prueba.pila.pruebatecnicapila.controller;

import com.prueba.pila.pruebatecnicapila.services.MedicamentoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/es/medicamento")
@CrossOrigin("*")
public class MedicamentoController {

    @Autowired
    private MedicamentoService medicamentoService;

    @Operation(summary = "Trae todos los medicamentos que le han formulado a un paciente - Como\n" +
            "entrada se debe enviar el nro de identificación del paciente.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error"),})
    @GetMapping("/medicamentos-paciente/{nroIdentificacion}/{page}/{size}")
    public ResponseEntity<?> medicamentosPaciente(@PathVariable String nroIdentificacion, @PathVariable int page, @PathVariable int size) {
        var medicamentos= medicamentoService.medicamentosPaciente(nroIdentificacion, page,size);
        if(medicamentos == null){
            return new ResponseEntity<>("{}", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(medicamentos, HttpStatus.OK);
    }
}
