package com.contador.msvc_asignaciones.models.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "asignaciones")
public class Asignacion {

    @Id
    private String id;

    // referencia simple a la Solicitud (solo el ID)
    private String solicitudId;

    // ejemplo: "ASISTENTE", "CONTADOR" o el nombre
    private String asignadoA;

    // ejemplo: "ASIGNADA", "EN_PROCESO", "FINALIZADA"
    private String estado;

    private LocalDateTime fechaCreacion = LocalDateTime.now();

    public Asignacion() {}

    public String getId() {
        return id;
    }

    public String getSolicitudId() {
        return solicitudId;
    }

    public void setSolicitudId(String solicitudId) {
        this.solicitudId = solicitudId;
    }

    public String getAsignadoA() {
        return asignadoA;
    }

    public void setAsignadoA(String asignadoA) {
        this.asignadoA = asignadoA;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
}