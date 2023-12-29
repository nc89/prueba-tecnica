package com.prueba.pila.pruebatecnicapila.repository;

import com.prueba.pila.pruebatecnicapila.models.MedicamentoEntity;
import com.prueba.pila.pruebatecnicapila.models.PacienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
@Repository
public interface PacienteRepository extends JpaRepository<PacienteEntity,Long> {
    public PacienteEntity findByNroIdentificiacion(String nroidentificacion);
    @Query(value = "SELECT * FROM paciente p INNER JOIN cita c ON p.id_paciente=c.id_paciente INNER JOIN medico m ON c.id_medico=m.id_medico WHERE m.nro_licencia=:nroLicencia AND c.fecha = :fecha and c.hora >= :horaInicio and c.hora <= :horafin",nativeQuery = true)
    List<PacienteEntity> findByFechaAndHoraBetween(String nroLicencia, LocalDate fecha, String horaInicio, String horafin);
}
