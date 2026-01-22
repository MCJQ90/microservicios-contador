package com.contador.msvc_solicitud.controller;

import com.contador.msvc_solicitud.models.entities.Solicitud;
import com.contador.msvc_solicitud.service.SolicitudService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.core.env.Environment;

import java.util.List;

@RestController
@RequestMapping("/solicitudes")
public class SolicitudController {

    private final SolicitudService service;

    private final Environment env;
    public SolicitudController(SolicitudService service, Environment env) {
        this.service = service;
        this.env = env;
    }

    @GetMapping
    public List<Solicitud> listar() {
        List<Solicitud> solicitudes = service.listar();

        solicitudes.forEach(s ->
        s.setPort(Integer.parseInt(env.getProperty("local.server.port")))
    );

    return solicitudes;
    }

    @PostMapping
    public Solicitud crear(@RequestBody Solicitud solicitud) {
        return service.crear(solicitud);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Solicitud> obtener(@PathVariable String id) {
        return service.obtenerPorId(id)
                .map(s -> {
                    s.setPort(Integer.parseInt(env.getProperty("local.server.port")));
                return ResponseEntity.ok(s);
            })
                .orElse(ResponseEntity.notFound().build());
    }
}