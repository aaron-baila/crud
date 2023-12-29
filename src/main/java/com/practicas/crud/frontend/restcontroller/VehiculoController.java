package com.practicas.crud.frontend.restcontroller;

import com.practicas.crud.backend.entity.Vehiculo;
import com.practicas.crud.backend.service.VehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/vehiculos")
public class VehiculoController {

    @Autowired
    private VehiculoService vehiculoService;

    @GetMapping
    public List<Vehiculo> getAll() {
        return vehiculoService.getAll();
    }

    @PostMapping
    public ResponseEntity<?> createVehiculo(@RequestBody Vehiculo vehiculo, UriComponentsBuilder direccion) {

        try {
            Vehiculo nuevoVehiculo = vehiculoService.create(vehiculo);
            Long id = nuevoVehiculo.getId();

            return ResponseEntity
                    .created(direccion.path("/vehiculos/{id}").build(id))
                    .body(nuevoVehiculo + "\r\nCreado satisfactoriamente");

//            return ResponseEntity
//                    .created(direccion.path("/vehiculos/{id}").build(id))
//                    .build();


        } catch (IllegalStateException e) {
            //TODO crear nuestras propias excepciones
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        vehiculoService.delete(id);
        return ResponseEntity.ok("Vehículo con el id: "+ id + " eliminado correctamente");
        //quizas mejor la excepcion aqui y con un 204
    }

//    @DeleteMapping("/{id}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void delete(@PathVariable Long id){
//        vehiculoService.delete(id);
//    }

}