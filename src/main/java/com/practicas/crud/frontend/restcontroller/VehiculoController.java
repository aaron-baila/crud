package com.practicas.crud.frontend.restcontroller;

import com.practicas.crud.backend.entity.Vehiculo;
import com.practicas.crud.backend.service.VehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/vehiculos")
public class VehiculoController {

    @Autowired
    private VehiculoService vehiculoService;

    @GetMapping
    public List<Vehiculo> getAll(){
        return  vehiculoService.getAll();
    }
}
