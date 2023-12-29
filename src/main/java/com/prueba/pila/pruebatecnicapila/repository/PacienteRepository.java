package com.prueba.pila.pruebatecnicapila.repository;

import com.prueba.pila.pruebatecnicapila.dto.PacientesDto;
import com.prueba.pila.pruebatecnicapila.models.MedicamentoEntity;
import com.prueba.pila.pruebatecnicapila.models.PacienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
@Repository
public interface PacienteRepository extends JpaRepository<PacienteEntity,Long> {
    public PacienteEntity findByNroIdentificiacion(String nroidentificacion);
    @Query(value = "SELECT p.nombre, p.apellido FROM PacienteEntity p INNER JOIN CitaEntity c ON p.idPaciente=c.paciente.idPaciente INNER JOIN MedicoEntity m ON c.medico.idMedico=m.idMedico WHERE m.nroLicencia=:nroLicencia AND c.fechahora >= :fechaInicial AND c.fechahora <=:fechaFinal")
    List<String> findByFechaAndHoraBetween(String nroLicencia, LocalDateTime fechaInicial, LocalDateTime fechaFinal);
}
