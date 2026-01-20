package com.contador.msvc_solicitud.repository;

import com.contador.msvc_solicitud.models.entities.Solicitud;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SolicitudRepository extends JpaRepository<Solicitud, Long> {

}
