package com.practicas.crud.backend.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;

import java.util.Date;

@Validated
@Entity
@Table(name = "MANTENIMIENTOS")
@Data
@NoArgsConstructor
public class Mantenimiento {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MANTENIMIENTOS_SEQ")
    private Long id;

    @Column(name = "TIPO")
    @Enumerated(EnumType.STRING)
    private TipoMantenimiento TipoMantenimiento;

    @Column
    @Temporal(TemporalType.DATE)
    private Date fecha;

    @Column(name = "KM")
    private Long kilomentros;

    @Column(name = "PROXIMA")
    @Temporal(TemporalType.DATE)
    private Date proximaRevision;

    @Column
    private  String descripcion;

    @ManyToOne
    @JoinColumn(name="VEHICULO")
    private Vehiculo vehiculo;

}
