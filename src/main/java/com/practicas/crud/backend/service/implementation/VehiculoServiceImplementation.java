package com.practicas.crud.backend.service.implementation;

import com.practicas.crud.backend.entity.Vehiculo;
import com.practicas.crud.backend.repository.VehiculoRepository;
import com.practicas.crud.backend.service.VehiculoService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class VehiculoServiceImplementation implements VehiculoService {
    @Autowired
    private VehiculoRepository vehiculoRepository;

    @Override
    @Transactional
    public Vehiculo create(Vehiculo vehiculo) {

        if (vehiculo.getId() != null) {
            throw new IllegalStateException("El ID debe de ser null");
        }
        return vehiculoRepository.save(vehiculo);
    }

    @Override
    public Vehiculo read(Long id) {
        return null;
    }

    @Override
    public void update(Vehiculo vehiculo) {

    }

    @Override
    public void delete(Long id) {

        boolean existe = vehiculoRepository.existsById(id);

        if (!existe) {
            throw new IllegalStateException("No existe un vehiculo con el id [" + id + "]");
        }
        vehiculoRepository.deleteById(id);

    }

//    @Override
//    public void delete(Long id) {
//
//        boolean existe = vehiculoRepository.existsById(id);
//
//        if (!existe) {
//            throw new IllegalStateException("No existe un vehiculo con el id [" + id + "]");
//        }
//        vehiculoRepository.deleteById(id);
//    }

    @Override
    public List<Vehiculo> getAll() {
        return vehiculoRepository.findAll();
    }

    @Override
    public Vehiculo getById(Long id) {
        return vehiculoRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("No se encontró el vehículo con id " + id));
    }

}