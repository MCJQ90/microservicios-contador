package com.contador.msvc_asignaciones.client;

import com.contador.msvc_asignaciones.models.entities.SolicitudDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "msvc-solicitud")
public interface SolicitudClient {

    @GetMapping("/solicitudes/{id}")
    SolicitudDTO obtenerSolicitud(@PathVariable String id);
}