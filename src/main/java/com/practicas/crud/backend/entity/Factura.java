package com.practicas.crud.backend.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import java.util.Date;

@Validated
@Entity
@Table(name = "FACTURAS")
@Data
@NoArgsConstructor
public class Factura {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FACTURAS_SEQ")
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;

}
