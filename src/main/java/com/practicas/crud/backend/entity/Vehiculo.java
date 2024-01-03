package com.practicas.crud.backend.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.validation.annotation.Validated;

import java.util.Objects;

@Validated
@Entity
@Table(name = "VEHICULOS")
@Data
@NoArgsConstructor


public class Vehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "VEHICULOS_SEQ")
    private Long id;

    @Column(name = "MATRICULA")
    private String Matricula;

    @Column(name = "MODELO")
    private String Modelo;

    @Column(name = "KM")
    private Long Kilometros;

    public Vehiculo(String matricula, String modelo, Long kilometros) {
        this.Matricula = matricula;
        this.Modelo = modelo;
        this.Kilometros = kilometros;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehiculo vehiculo = (Vehiculo) o;
        return Objects.equals(id, vehiculo.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}