package com.practicas.crud.backend.service;

import com.practicas.crud.backend.entity.VehiculoEntity;

import java.util.List;

public interface VehiculoService {

    VehiculoEntity create(VehiculoEntity vehiculoEntity);
    VehiculoEntity read(Long id);
    void update(VehiculoEntity vehiculoEntity);
    void delete(Long id);
    List<VehiculoEntity> getAll();
    VehiculoEntity getById(Long id);

}
