package com.contador.msvc_solicitud.repository;

import com.contador.msvc_solicitud.models.entities.Solicitud;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SolicitudRepository extends MongoRepository<Solicitud, String> {
}