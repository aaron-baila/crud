package com.practicas.crud.backend.repository;

import com.practicas.crud.backend.entity.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehiculoRepository extends JpaRepository<Vehiculo, Long> {
}
