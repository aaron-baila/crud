package com.practicas.crud.frontend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class prueba {
    
    @GetMapping("/prueba")
    public String prueba(Model model) {
        model.addAttribute("title", "Hola mundo");
        return "prueba";
    }
    
  
}
