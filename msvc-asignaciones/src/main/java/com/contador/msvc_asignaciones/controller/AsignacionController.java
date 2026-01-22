package com.contador.msvc_asignaciones.controller;


import com.contador.msvc_asignaciones.models.entities.Asignacion;
import com.contador.msvc_asignaciones.service.AsignacionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.core.env.Environment;
import com.contador.msvc_asignaciones.models.entities.AsignacionDetalleDTO;
import com.contador.msvc_asignaciones.models.entities.SolicitudDTO;
import com.contador.msvc_asignaciones.client.SolicitudClient;
import java.util.HashMap;
import java.util.Map;

import java.util.List;

@RestController
@RequestMapping("/asignaciones")
public class AsignacionController {

    private final AsignacionService service;
    private final SolicitudClient solicitudClient;

    private final Environment env;
    public AsignacionController(AsignacionService service, Environment env, SolicitudClient solicitudClient) {
        this.service = service;
        this.env = env;
        this.solicitudClient = solicitudClient;
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
    
    @GetMapping("/{id}/detalle")
    public ResponseEntity<AsignacionDetalleDTO> detalle(@PathVariable String id) {

        return service.obtenerPorId(id)
                .map(asignacion -> {
                    asignacion.setPort(Integer.parseInt(env.getProperty("local.server.port")));
                SolicitudDTO solicitud = solicitudClient.obtenerSolicitud(asignacion.getSolicitudId());
                Map<String, Object> info = new HashMap<>();
                info.put("asignacion", asignacion);
                info.put("solicitud", solicitud);

                return ResponseEntity.ok(new AsignacionDetalleDTO(asignacion, solicitud));
            })
            .orElse(ResponseEntity.notFound().build());
}
}
