package com.contador.msvc_asignaciones.controller;


import com.contador.msvc_asignaciones.models.entities.Asignacion;
import com.contador.msvc_asignaciones.service.AsignacionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/asignaciones")
public class AsignacionController {

    private final AsignacionService service;

    public AsignacionController(AsignacionService service) {
        this.service = service;
    }

    @GetMapping
    public List<Asignacion> listar() {
        return service.listar();
    }

    @PostMapping
    public Asignacion crear(@RequestBody Asignacion asignacion) {
        return service.crear(asignacion);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Asignacion> obtener(@PathVariable String id) {
        return service.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}