package com.practicas.crud.frontend.restcontroller;

import com.practicas.crud.backend.entity.Mantenimiento;
import com.practicas.crud.backend.entity.VehiculoEntity;
import com.practicas.crud.backend.service.MantenimientoService;
import com.practicas.crud.backend.service.VehiculoService;
import com.practicas.crud.frontend.config.FrontendException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/vehiculos")
public class VehiculoController {

    @Autowired
    private VehiculoService vehiculoService;

    @Autowired
    private MantenimientoService mantenimientoService;

    @GetMapping
    public List<VehiculoEntity> getAll() {
        return vehiculoService.getAll();
    }
    @GetMapping("/first")
    public VehiculoEntity getFirst() {
        return vehiculoService.getFirst();
    }

    @GetMapping("/{id}")
    public VehiculoEntity getVehiculo(@PathVariable Long id) {
        return vehiculoService.getById(id);
    }

    @PostMapping
    public ResponseEntity<?> createVehiculo(@RequestBody VehiculoEntity vehiculoEntity, UriComponentsBuilder direccion) {

        try {
            VehiculoEntity nuevoVehiculoEntity = vehiculoService.create(vehiculoEntity);
            Long id = nuevoVehiculoEntity.getId();

            return ResponseEntity
                    .created(direccion.path("/vehiculos/{id}").build(id))
                    .body(nuevoVehiculoEntity + "\r\nCreado satisfactoriamente");
//          Si no queremos poner  mensaje podemos poner build en ved de body
//                    .build();
        } catch (IllegalStateException e) {
            throw new FrontendException(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        try {
            vehiculoService.delete(id);
        } catch (IllegalStateException e) {
            throw new FrontendException(e.getMessage(), HttpStatus.NO_CONTENT);
        }
        return ResponseEntity.ok("Vehículo con el id: " + id + " eliminado correctamente");

    }

    @PutMapping()
    public ResponseEntity<String> update(@RequestBody VehiculoEntity vehiculoEntity) {
        Long id = vehiculoEntity.getId();
        try {
            vehiculoService.update(vehiculoEntity);

        } catch (Exception e) {
            throw new RuntimeException();
        }
        return ResponseEntity.ok("Vehículo con el id: " + id + " modificado correctamente");

    }

    @GetMapping("/{id}/mantenimientos")
    public List<Mantenimiento> getMantenimientoVehiculo(@PathVariable Long id) {

        return mantenimientoService.getAll()
                .stream()
                .filter(p -> p.getIdVehiculo() == (id))
                .collect(Collectors.toList());

    }

}