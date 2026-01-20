package com.contador.msvc_asignaciones.repository;

import com.contador.msvc_asignaciones.models.entities.Asignacion;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AsignacionRepository extends MongoRepository<Asignacion, Long> {
}