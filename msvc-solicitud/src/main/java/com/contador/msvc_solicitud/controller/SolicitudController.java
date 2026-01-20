package com.contador.msvc_solicitud.controller;

import com.contador.msvc_solicitud.models.entities.Solicitud;
import com.contador.msvc_solicitud.repository.SolicitudRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/solicitudes")
public class SolicitudController {

    private final SolicitudRepository solicitudRepository;

    public SolicitudController(SolicitudRepository solicitudRepository) {
        this.solicitudRepository = solicitudRepository;
    }

    // 1) Listar
    @GetMapping
    public List<Solicitud> listar() {
        return solicitudRepository.findAll();
    }

    // 2) Crear
    @PostMapping
    public Solicitud crear(@RequestBody Solicitud solicitud) {
        // por defecto, si no envían estado
        if (solicitud.getEstado() == null || solicitud.getEstado().isBlank()) {
            solicitud.setEstado("ENVIADA");
        }
        return solicitudRepository.save(solicitud);
    }

    // 3) Obtener por id
    @GetMapping("/{id}")
    public ResponseEntity<Solicitud> obtener(@PathVariable Long id) {
        return solicitudRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
