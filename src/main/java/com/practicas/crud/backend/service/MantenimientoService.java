package com.practicas.crud.backend.service;

import com.practicas.crud.backend.entity.Mantenimiento;

import java.util.List;

public interface MantenimientoService {

    Mantenimiento create(Mantenimiento mantenimiento);
    Mantenimiento read(Long id);
    void update(Mantenimiento mantenimiento);
    void delete(Long id);
    List<Mantenimiento> getAll();
    Mantenimiento getById(Long id);

}
