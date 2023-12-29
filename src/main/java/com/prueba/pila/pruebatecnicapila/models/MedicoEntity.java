package com.prueba.pila.pruebatecnicapila.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name="medico")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class MedicoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_medico")
    private Long idMedico;

    @Column(name="nro_licencia")
    private String nroLicencia;

    @Column(name="nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name="especialidad")
    private String especialidad;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            orphanRemoval = true,
            mappedBy = "medico"
    )
    private Set<CitaEntity> citas;
}
