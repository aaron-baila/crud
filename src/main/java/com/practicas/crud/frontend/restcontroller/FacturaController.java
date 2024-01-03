package com.practicas.crud.frontend.restcontroller;

import com.practicas.crud.backend.entity.Factura;
import com.practicas.crud.backend.service.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/facturas")
public class FacturaController {

    @Autowired
    private FacturaService facturaService;

    @GetMapping
    public List<Factura> getAll() {
        return facturaService.getAll();
    }

    @PostMapping
    public ResponseEntity<?> createFactura(@RequestBody Factura factura, UriComponentsBuilder direccion) {

        try {
            Factura nuevoFactura = facturaService.create(factura);
            Long id = nuevoFactura.getId();

            return ResponseEntity
                    .created(direccion.path("/facturas/{id}").build(id))
                    .body(nuevoFactura + "\r\nCreado satisfactoriamente");

//            return ResponseEntity
//                    .created(direccion.path("/facturas/{id}").build(id))
//                    .build();


        } catch (IllegalStateException e) {
            //TODO crear nuestras propias excepciones
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        facturaService.delete(id);
        return ResponseEntity.ok("Vehículo con el id: "+ id + " eliminado correctamente");
        //quizas mejor la excepcion aqui y con un 204
    }

//    @DeleteMapping("/{id}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void delete(@PathVariable Long id){
//        facturaService.delete(id);
//    }

}