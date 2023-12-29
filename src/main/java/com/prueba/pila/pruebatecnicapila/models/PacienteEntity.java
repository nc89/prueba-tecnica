package com.prueba.pila.pruebatecnicapila.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;


import java.util.Set;

@Entity
@Table(name="paciente")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class PacienteEntity {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name="id_paciente")
    private Long idPaciente;

    @Column(name="nro_identificacion")
    private String nroIdentificiacion;

    @Column(name="nombre")
    private String nombre;

    @Column(name="apellido")
    private String apellido;

    @Column(name="edad")
    private Integer edad;

    @Column(name="genero")
    private String genero;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            orphanRemoval = true,
            mappedBy = "paciente"
    )
    @JsonManagedReference
    private Set<CitaEntity> citas;
}
