package com.prueba.pila.pruebatecnicapila.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

import java.util.Set;

@Entity
@Table(name="cita")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CitaEntity {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name="id_cita")
    private Long idCita;

    @Column(name="fecha")
    private LocalDateTime fechahora;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            orphanRemoval = true,
            mappedBy = "cita"
    )
    @JsonManagedReference
    private Set<MedicamentoEntity> medicamentos;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_paciente")
    @JsonBackReference
    private PacienteEntity paciente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_medico")
    private MedicoEntity medico;
}
