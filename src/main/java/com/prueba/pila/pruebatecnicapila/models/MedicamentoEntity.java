package com.prueba.pila.pruebatecnicapila.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="medicamento")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class MedicamentoEntity {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name="id_medicamento")
    private Long idMedicamento;

    @Column(name="nro_lote")
    private Integer nroLote;

    @Column(name="nombre")
    private String nombre;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cita")
    @JsonBackReference
    private CitaEntity cita;

}
