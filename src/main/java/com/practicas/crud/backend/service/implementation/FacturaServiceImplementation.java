package com.practicas.crud.backend.service.implementation;

import com.practicas.crud.backend.entity.Factura;
import com.practicas.crud.backend.repository.FacturaRepository;

import com.practicas.crud.backend.service.FacturaService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class FacturaServiceImplementation implements FacturaService {
    @Autowired
    private FacturaRepository facturaRepository;

    @Override
    @Transactional
    public Factura create(Factura factura) {

        if (factura.getId() != null) {
            throw new IllegalStateException("El ID debe de ser null");
        }
        return facturaRepository.save(factura);
    }

    @Override
    public Factura read(Long id) {
        return null;
    }

    @Override
    public void update(Factura factura) {

    }

    @Override
    public void delete(Long id) {

        boolean existe = facturaRepository.existsById(id);

        if (!existe) {
            throw new IllegalStateException("No existe una Factura con el id [" + id + "]");
        }
        facturaRepository.deleteById(id);

    }

//    @Override
//    public void delete(Long id) {
//
//        boolean existe = facturaRepository.existsById(id);
//
//        if (!existe) {
//            throw new IllegalStateException("No existe un Factura con el id [" + id + "]");
//        }
//        facturaRepository.deleteById(id);
//    }

    @Override
    public List<Factura> getAll() {
        return facturaRepository.findAll();
    }

    @Override
    public Factura getById(Long id) {
        return facturaRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("No se encontró el vehículo con id " + id));
    }

}