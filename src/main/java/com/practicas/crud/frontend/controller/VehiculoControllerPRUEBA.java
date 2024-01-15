package com.practicas.crud.frontend.controller;

import com.practicas.crud.backend.entity.VehiculoEntity;
import com.practicas.crud.backend.service.VehiculoService;
import com.practicas.crud.backend.service.implementation.MantenimientoServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
public class VehiculoControllerPRUEBA {
    @Autowired
    VehiculoService vehiculoService;

   @GetMapping("/vehiculo/{id}")
  public String vehiculo(Model model, @PathVariable Long id) {

       VehiculoEntity vehiculo = vehiculoService.getById(id);

       model.addAttribute("title",vehiculo.getMatricula() + " - " + vehiculo.getModelo() );
       model.addAttribute("Kilometros", vehiculo.getKilometros());
      return "vehiculo";
    }
    
  
}
