package com.contador.msvc_asignaciones.repository;

import com.contador.msvc_asignaciones.models.entities.Asignacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AsignacionRepository extends JpaRepository<Asignacion, Long> {
}