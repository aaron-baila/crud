package com.practicas.crud.frontend.controller;

import com.practicas.crud.backend.entity.Vehiculo;
import com.practicas.crud.backend.service.VehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/home")
public class VehiculoAppController {

    @Autowired
    VehiculoService vehiculoService;
    @GetMapping("/ficha-vehiculo")
    public ModelAndView getFichaVehiculo(@RequestParam Long codigo, ModelAndView modelAndView) {

        Vehiculo vehiculo = vehiculoService.read(codigo);

        modelAndView.setViewName("ficha-vehiculo");
        modelAndView.addObject("vehiculo", vehiculo);

        return modelAndView;
    }
}
