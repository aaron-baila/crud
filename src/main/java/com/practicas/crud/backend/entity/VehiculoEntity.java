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
public class VehiculoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "VEHICULOS_SEQ")
    private Long id;

    @Column(name = "MATRICULA")
    private String matricula;

    @Column(name = "MODELO")
    private String modelo;

    @Column(name = "KM")
    private Long kilometros;
//
//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "vehiculo", cascade = CascadeType.ALL)
//    private List<Mantenimiento> mantenimientos = new ArrayList<>();

    public VehiculoEntity(String matricula, String modelo, Long kilometros) {
        this.matricula = matricula;
        this.modelo = modelo;
        this.kilometros = kilometros;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VehiculoEntity vehiculoEntity = (VehiculoEntity) o;
        return Objects.equals(id, vehiculoEntity.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}