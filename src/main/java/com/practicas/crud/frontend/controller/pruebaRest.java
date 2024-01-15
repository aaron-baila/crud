package com.practicas.crud.frontend.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practicas.crud.backend.entity.VehiculoEntity;



@RestController
public class pruebaRest {
    
    @GetMapping("/pruebarest")
    public Map<String, Object> prueba() {
        Map<String, Object> body = new HashMap<>();

        body.put("title", "Hola mundo");
        VehiculoEntity vehiculoEntity = new VehiculoEntity("8874GDF","Renault", (long) 19000);
    
        body.put("vehiculo", vehiculoEntity);

        return body;
    }
    
  
}
