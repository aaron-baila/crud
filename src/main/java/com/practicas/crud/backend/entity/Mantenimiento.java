package com.practicas.crud.backend.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import java.util.Date;

@Validated
@Entity
@Table(name = "MANTENIMIENTOS")
@Data
@NoArgsConstructor
public class Mantenimiento {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MANTENIMIENTOS_SEQ")
    private Long mantenimiento;

    @Column(name = "TIPO")
    @Enumerated(EnumType.STRING)
    private TipoMantenimiento TipoMantenimiento;

    @Column
    @Temporal(TemporalType.DATE)
    private Date fecha;

    @Column(name = "KM")
    private Long kilometros;

    @Column(name = "PROXIMA")
    @Temporal(TemporalType.DATE)
    private Date proximaRevision;

    @Column
    private  String descripcion;

    @Column(name = "VEHICULO")
    private Long idVehiculo;

//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name="VEHICULO")
//    private Vehiculo vehiculo;

}
