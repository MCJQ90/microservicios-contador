package com.contador.msvc_asignaciones.models.entities;


public class AsignacionDetalleDTO {

    private Asignacion asignacion;
    private SolicitudDTO solicitud;

    public AsignacionDetalleDTO() {}

    public AsignacionDetalleDTO(Asignacion asignacion, SolicitudDTO solicitud) {
        this.asignacion = asignacion;
        this.solicitud = solicitud;
    }

    public Asignacion getAsignacion() { return asignacion; }
    public void setAsignacion(Asignacion asignacion) { this.asignacion = asignacion; }

    public SolicitudDTO getSolicitud() { return solicitud; }
    public void setSolicitud(SolicitudDTO solicitud) { this.solicitud = solicitud; }
}