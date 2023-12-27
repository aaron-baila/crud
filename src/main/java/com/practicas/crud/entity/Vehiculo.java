package com.practicas.crud.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.springframework.validation.annotation.Validated;



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

    public Vehiculo(String matricula, String modelo, Long kilometros) {
        this.Matricula = matricula;
        this.Modelo = modelo;
        this.Kilometros = kilometros;
    }
}
