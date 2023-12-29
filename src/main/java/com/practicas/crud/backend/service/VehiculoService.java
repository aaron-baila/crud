package com.practicas.crud.backend.service;

import com.practicas.crud.backend.entity.Vehiculo;

import java.util.List;

public interface VehiculoService {

    Vehiculo create(Vehiculo vehiculo);
    Vehiculo read(Long id);
    void update(Vehiculo vehiculo);
    void delete(Long id);
    List<Vehiculo> getAll();
    Vehiculo getById(Long id);

}
