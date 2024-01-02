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
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MANTENIMIENTOS_SEW")
    private Long id;

    @Column
    @Enumerated(EnumType.STRING)
    private TipoMantenimiento TipoMantenimiento;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;

    @Column
    private Long kilomentros;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date proximaRevision;

    @Column
    private Factura factura;

    @Column
    private  String descripcion;

}
