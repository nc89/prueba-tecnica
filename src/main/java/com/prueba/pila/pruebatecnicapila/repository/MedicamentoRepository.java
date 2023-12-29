package com.prueba.pila.pruebatecnicapila.repository;

import com.prueba.pila.pruebatecnicapila.models.MedicamentoEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface MedicamentoRepository extends JpaRepository<MedicamentoEntity,Long> {
    @Query("SELECT m FROM MedicamentoEntity m WHERE m.cita.paciente.nroIdentificiacion = :nroIdentificiacion")
    Page<MedicamentoEntity> findByPacienteNroIdentificiacion(@Param("nroIdentificiacion") String nroIdentificiacion, Pageable pageable);
}
