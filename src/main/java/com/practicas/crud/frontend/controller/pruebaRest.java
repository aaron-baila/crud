package com.practicas.crud.frontend.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class pruebaRest {
    
    @GetMapping("/pruebarest")
    public Map<String, Object> prueba() {
        Map<String, Object> body = new HashMap<>();

        body.put("title", "Hola mundo");
        body.put("name", "Pepe");
        body.put("surname", "Garcia");

        return body;
    }
    
  
}
