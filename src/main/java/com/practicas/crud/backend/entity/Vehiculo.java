package com.practicas.crud.backend.entity;

import jakarta.persistence.*;
import org.springframework.validation.annotation.Validated;

import java.util.Objects;

@Validated
@Entity
@Table(name = "VEHICULOS")
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

    public Vehiculo() {
    }

    public Long getId() {
        return id;
    }

    public String getMatricula() {
        return Matricula;
    }

    public void setMatricula(String matricula) {
        Matricula = matricula;
    }

    public String getModelo() {
        return Modelo;
    }

    public void setModelo(String modelo) {
        Modelo = modelo;
    }

    public Long getKilometros() {
        return Kilometros;
    }

    public void setKilometros(Long kilometros) {
        Kilometros = kilometros;
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