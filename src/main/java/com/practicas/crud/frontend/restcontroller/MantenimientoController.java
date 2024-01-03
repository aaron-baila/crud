package com.practicas.crud.frontend.restcontroller;

import com.practicas.crud.backend.entity.Mantenimiento;
import com.practicas.crud.backend.service.MantenimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/mantenimientos")
public class MantenimientoController {

    @Autowired
    private MantenimientoService mantenimientoService;

    @GetMapping
    public List<Mantenimiento> getAll() {
        return mantenimientoService.getAll();
    }

    @PostMapping
    public ResponseEntity<?> createMantenimiento(@RequestBody Mantenimiento mantenimiento, UriComponentsBuilder direccion) {

        try {
            Mantenimiento nuevoMantenimiento = mantenimientoService.create(mantenimiento);
            Long id = nuevoMantenimiento.getId();

            return ResponseEntity
                    .created(direccion.path("/mantenimientos/{id}").build(id))
                    .body(nuevoMantenimiento + "\r\nCreado satisfactoriamente");

//            return ResponseEntity
//                    .created(direccion.path("/mantenimientos/{id}").build(id))
//                    .build();


        } catch (IllegalStateException e) {
            //TODO crear nuestras propias excepciones
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        mantenimientoService.delete(id);
        return ResponseEntity.ok("Vehículo con el id: "+ id + " eliminado correctamente");
        //quizas mejor la excepcion aqui y con un 204
    }

//    @DeleteMapping("/{id}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void delete(@PathVariable Long id){
//        mantenimientoService.delete(id);
//    }

}