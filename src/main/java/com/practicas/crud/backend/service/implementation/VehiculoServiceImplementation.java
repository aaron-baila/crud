package com.practicas.crud.backend.service.implementation;

import com.practicas.crud.backend.entity.VehiculoEntity;
import com.practicas.crud.backend.repository.VehiculoRepository;
import com.practicas.crud.backend.service.VehiculoService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
public class VehiculoServiceImplementation implements VehiculoService {
    @Autowired
    private VehiculoRepository vehiculoRepository;

    @Override
    @Transactional
    public VehiculoEntity create(VehiculoEntity vehiculoEntity) {

        if (vehiculoEntity.getId() != null) {
            throw new IllegalStateException("El ID debe de ser null");
        }
        return vehiculoRepository.save(vehiculoEntity);
    }

    @Override
    public VehiculoEntity read(Long id) {
        return null;
    }

    @Transactional
    @Override
    public void update(VehiculoEntity vehiculoEntity) {
        boolean existe = vehiculoRepository.existsById(vehiculoEntity.getId());

        if (!existe) {
            throw new IllegalStateException("No existe un vehiculo con el id [" + vehiculoEntity.getId() + "]");
        }
        vehiculoRepository.save(vehiculoEntity);

    }

    @Transactional
    @Override
    public void delete(Long id) {

        boolean existe = vehiculoRepository.existsById(id);

        if (!existe) {
            throw new IllegalStateException("No existe un vehiculo con el id [" + id + "]");
        }
        vehiculoRepository.deleteById(id);

    }


    @Override
    public List<VehiculoEntity> getAll() {
        return vehiculoRepository.findAll();
    }

    @Override
    public VehiculoEntity getById(Long id) {
        return vehiculoRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("No se encontró el vehículo con id " + id));
    }

}