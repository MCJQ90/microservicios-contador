package com.contador.msvc_asignaciones.models.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "asignaciones")
public class Asignacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // referencia simple a la Solicitud (solo el ID)
    private Long solicitudId;

    // ejemplo: "ASISTENTE", "CONTADOR" o el nombre
    private String asignadoA;

    // ejemplo: "ASIGNADA", "EN_PROCESO", "FINALIZADA"
    private String estado;

    private LocalDateTime fechaCreacion = LocalDateTime.now();

    public Asignacion() {}

    public Long getId() { return id; }

    public Long getSolicitudId() { return solicitudId; }
    public void setSolicitudId(Long solicitudId) { this.solicitudId = solicitudId; }

    public String getAsignadoA() { return asignadoA; }
    public void setAsignadoA(String asignadoA) { this.asignadoA = asignadoA; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public LocalDateTime getFechaCreacion() { return fechaCreacion; }
    public void setFechaCreacion(LocalDateTime fechaCreacion) { this.fechaCreacion = fechaCreacion; }
}