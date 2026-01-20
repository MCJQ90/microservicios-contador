package com.contador.msvc_asignaciones.service;

import com.contador.msvc_asignaciones.models.entities.Asignacion;
import com.contador.msvc_asignaciones.repository.AsignacionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AsignacionService {

    private final AsignacionRepository repository;

    public AsignacionService(AsignacionRepository repository) {
        this.repository = repository;
    }

    public List<Asignacion> listar() {
        return repository.findAll();
    }

    public Asignacion crear(Asignacion asignacion) {
        if (asignacion.getEstado() == null || asignacion.getEstado().isBlank()) {
            asignacion.setEstado("ASIGNADA");
        }
        return repository.save(asignacion);
    }

    public Optional<Asignacion> obtenerPorId(String id) {
        return repository.findById(id);
    }
}