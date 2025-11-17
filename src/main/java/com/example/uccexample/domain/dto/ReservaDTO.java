package com.example.uccexample.domain.dto;

import com.example.uccexample.infraestructure.enums.EstadoReserva;
import java.time.LocalDateTime;

public class ReservaDTO {
    private Long id;
    private Long clienteId;
    private Long mesaId;
    private String clienteNombre;
    private Integer mesaNumero;
    private LocalDateTime fechaHora;
    private Integer personas;
    private EstadoReserva estado;

    public ReservaDTO() {}

    public ReservaDTO(
            Long id,
            Long clienteId,
            Long mesaId,
            String clienteNombre,
            Integer mesaNumero,
            LocalDateTime fechaHora,
            Integer personas,
            EstadoReserva estado) {
        this.id = id;
        this.clienteId = clienteId;
        this.mesaId = mesaId;
        this.clienteNombre = clienteNombre;
        this.mesaNumero = mesaNumero;
        this.fechaHora = fechaHora;
        this.personas = personas;
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public Long getMesaId() {
        return mesaId;
    }

    public void setMesaId(Long mesaId) {
        this.mesaId = mesaId;
    }

    public String getClienteNombre() {
        return clienteNombre;
    }

    public void setClienteNombre(String clienteNombre) {
        this.clienteNombre = clienteNombre;
    }

    public Integer getMesaNumero() {
        return mesaNumero;
    }

    public void setMesaNumero(Integer mesaNumero) {
        this.mesaNumero = mesaNumero;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public Integer getPersonas() {
        return personas;
    }

    public void setPersonas(Integer personas) {
        this.personas = personas;
    }

    public EstadoReserva getEstado() {
        return estado;
    }

    public void setEstado(EstadoReserva estado) {
        this.estado = estado;
    }
}
