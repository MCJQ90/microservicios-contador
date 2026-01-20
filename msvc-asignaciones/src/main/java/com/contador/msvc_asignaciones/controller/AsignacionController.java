package com.contador.msvc_asignaciones.controller;


import com.contador.msvc_asignaciones.models.entities.Asignacion;
import com.contador.msvc_asignaciones.repository.AsignacionRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/asignaciones")
public class AsignacionController {

    private final AsignacionRepository asignacionRepository;

    public AsignacionController(AsignacionRepository asignacionRepository) {
        this.asignacionRepository = asignacionRepository;
    }

    @GetMapping
    public List<Asignacion> listar() {
        return asignacionRepository.findAll();
    }

    @PostMapping
    public Asignacion crear(@RequestBody Asignacion asignacion) {
        if (asignacion.getEstado() == null || asignacion.getEstado().isBlank()) {
            asignacion.setEstado("ASIGNADA");
        }
        return asignacionRepository.save(asignacion);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Asignacion> obtener(@PathVariable Long id) {
        return asignacionRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
