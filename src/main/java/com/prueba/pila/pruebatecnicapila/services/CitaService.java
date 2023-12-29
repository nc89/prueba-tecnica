package com.prueba.pila.pruebatecnicapila.services;

import com.prueba.pila.pruebatecnicapila.dto.PacientesDto;
import com.prueba.pila.pruebatecnicapila.dto.ResponseDto;
import com.prueba.pila.pruebatecnicapila.models.CitaEntity;
import com.prueba.pila.pruebatecnicapila.models.MedicoEntity;
import com.prueba.pila.pruebatecnicapila.models.PacienteEntity;
import com.prueba.pila.pruebatecnicapila.repository.CitaRepository;
import com.prueba.pila.pruebatecnicapila.repository.MedicoRepository;
import com.prueba.pila.pruebatecnicapila.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class CitaService {
    @Autowired
    private CitaRepository citaRepository;
    @Autowired
    private MedicoRepository medicoRepository;
    @Autowired
    private PacienteRepository pacienteRepository;

    public List<String> obtenerCitasPorFechaYHora(ResponseDto rdto) {
        Optional<MedicoEntity> medico= medicoRepository.findByNroLicencia(rdto.getNroLicencia());
        List<String> pacientes =null;
        if(medico.isPresent()){
            pacientes= pacienteRepository.findByFechaAndHoraBetween(rdto.getNroLicencia(),rdto.getFecha(),rdto.getHoraInicio(), rdto.getHoraFin());
        }

        return pacientes;
    }
}
