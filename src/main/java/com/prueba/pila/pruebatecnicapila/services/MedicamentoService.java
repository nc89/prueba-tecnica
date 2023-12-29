package com.prueba.pila.pruebatecnicapila.services;

import com.prueba.pila.pruebatecnicapila.models.MedicamentoEntity;
import com.prueba.pila.pruebatecnicapila.models.PacienteEntity;
import com.prueba.pila.pruebatecnicapila.repository.MedicamentoRepository;
import com.prueba.pila.pruebatecnicapila.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicamentoService {

    @Autowired
    private MedicamentoRepository medicamentoRepository;
    @Autowired
    private PacienteRepository pacienteRepository;

    public Page<MedicamentoEntity> medicamentosPaciente(String nroIdentificacion, int page, int size){
        PacienteEntity paciente= pacienteRepository.findByNroIdentificiacion(nroIdentificacion);
        if(paciente !=null){
            Pageable pageable = PageRequest.of(page, size);
            Page<MedicamentoEntity> query = medicamentoRepository.findByPacienteNroIdentificiacion(nroIdentificacion, pageable);
            return query;
        }
        return null;

    }
}
