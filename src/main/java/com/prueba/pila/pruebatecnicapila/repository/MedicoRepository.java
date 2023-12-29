package com.prueba.pila.pruebatecnicapila.repository;

import com.prueba.pila.pruebatecnicapila.models.MedicoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MedicoRepository extends JpaRepository<MedicoEntity,Long> {
    public Optional<MedicoEntity> findByNroLicencia(String nrolicencia);
}
