package com.practicas.crud.backend.repository;

import com.practicas.crud.backend.entity.Factura;
import com.practicas.crud.backend.entity.Mantenimiento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacturaRepository extends JpaRepository<Factura, Long> {
}
