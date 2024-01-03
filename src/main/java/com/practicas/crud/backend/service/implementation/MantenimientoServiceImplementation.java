package com.practicas.crud.backend.service.implementation;

import com.practicas.crud.backend.entity.Mantenimiento;
import com.practicas.crud.backend.repository.MantenimientoRepository;
import com.practicas.crud.backend.service.MantenimientoService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class MantenimientoServiceImplementation implements MantenimientoService {
    @Autowired
    private MantenimientoRepository mantenimientoRepository;

    @Override
    @Transactional
    public Mantenimiento create(Mantenimiento mantenimiento) {

        if (mantenimiento.getId() != null) {
            throw new IllegalStateException("El ID debe de ser null");
        }
        return mantenimientoRepository.save(mantenimiento);
    }

    @Override
    public Mantenimiento read(Long id) {
        return null;
    }

    @Override
    public void update(Mantenimiento mantenimiento) {

    }

    @Override
    public void delete(Long id) {

        boolean existe = mantenimientoRepository.existsById(id);

        if (!existe) {
            throw new IllegalStateException("No existe un Mantenimiento con el id [" + id + "]");
        }
        mantenimientoRepository.deleteById(id);

    }

//    @Override
//    public void delete(Long id) {
//
//        boolean existe = MantenimientoRepository.existsById(id);
//
//        if (!existe) {
//            throw new IllegalStateException("No existe un Mantenimiento con el id [" + id + "]");
//        }
//        MantenimientoRepository.deleteById(id);
//    }

    @Override
    public List<Mantenimiento> getAll() {
        return mantenimientoRepository.findAll();
    }

    @Override
    public Mantenimiento getById(Long id) {
        return mantenimientoRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("No se encontró el vehículo con id " + id));
    }

}