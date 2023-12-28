package com.practicas.crud.backend.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Data
public class VehiculoId implements Serializable {
    private static final long serialVersionUID = 1L;

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "VEHICULOS_SEQ")
    private Long id;

    @Getter
    @Setter
    @Column(name = "MATRICULA")
    private String Matricula;


}