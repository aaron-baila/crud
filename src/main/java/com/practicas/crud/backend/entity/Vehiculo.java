package com.practicas.crud.backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.springframework.validation.annotation.Validated;

import java.util.Objects;


@Validated
@Entity
@Table(name = "VEHICULOS")
public class Vehiculo {

    @Id
    @Column(name = "ID")
    private long id;

    @Column(name = "MATRICULA")
    private String Matricula;

    @Column(name = "MODELO")
    private String Modelo;

    @Column(name = "KM")
    private Long Kilometros;

    public Vehiculo() {
    }

    public long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehiculo vehiculo = (Vehiculo) o;
        return id == vehiculo.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public Vehiculo(String matricula, String modelo, Long kilometros) {
        this.Matricula = matricula;
        this.Modelo = modelo;
        this.Kilometros = kilometros;
    }
}
