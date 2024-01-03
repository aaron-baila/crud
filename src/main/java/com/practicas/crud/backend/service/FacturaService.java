package com.practicas.crud.backend.service;

import com.practicas.crud.backend.entity.Factura;

import java.util.List;

public interface FacturaService {

    Factura create(Factura factura);
    Factura read(Long id);
    void update(Factura factura);
    void delete(Long id);
    List<Factura> getAll();
    Factura getById(Long id);

}
