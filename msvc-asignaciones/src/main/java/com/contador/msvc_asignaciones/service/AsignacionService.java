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

    // Listar todas las asignaciones
    public List<Asignacion> listar() {
        return repository.findAll();
    }

    // Crear una nueva asignación
    public Asignacion crear(Asignacion asignacion) {

        if (asignacion.getEstado() == null || asignacion.getEstado().isBlank()) {
            asignacion.setEstado("ASIGNADA");
        }

        return repository.save(asignacion);
    }

    // Obtener asignación por id
    public Optional<Asignacion> obtenerPorId(Long id) {
        return repository.findById(id);
    }
}