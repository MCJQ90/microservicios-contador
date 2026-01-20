package com.contador.msvc_asignaciones.controller;


import com.contador.msvc_asignaciones.models.entities.Asignacion;
import com.contador.msvc_asignaciones.service.AsignacionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.core.env.Environment;

import java.util.List;

@RestController
@RequestMapping("/asignaciones")
public class AsignacionController {

    private final AsignacionService service;

    private final Environment env;
    public AsignacionController(AsignacionService service, Environment env) {
        this.service = service;
        this.env = env;
    }

    @GetMapping
    public List<Asignacion> listar() {
        List<Asignacion> asignaciones = service.listar();

        asignaciones.forEach(a ->
        a.setPort(Integer.parseInt(env.getProperty("local.server.port")))
    );

        return asignaciones;
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