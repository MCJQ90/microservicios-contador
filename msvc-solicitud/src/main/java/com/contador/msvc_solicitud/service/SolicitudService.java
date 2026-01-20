package com.contador.msvc_solicitud.service;

import com.contador.msvc_solicitud.models.entities.Solicitud;
import com.contador.msvc_solicitud.repository.SolicitudRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SolicitudService {

    private final SolicitudRepository repository;

    public SolicitudService(SolicitudRepository repository) {
        this.repository = repository;
    }

    public List<Solicitud> listar() {
        return repository.findAll();
    }

    public Solicitud crear(Solicitud solicitud) {
        if (solicitud.getEstado() == null || solicitud.getEstado().isBlank()) {
            solicitud.setEstado("ENVIADA");
        }
        return repository.save(solicitud);
    }

    public Optional<Solicitud> obtenerPorId(String id) {
        return repository.findById(id);
    }
}