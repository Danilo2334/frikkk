package com.example.uccexample.domain.dto;

import com.example.uccexample.infraestructure.enums.EstadoPedido;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class PedidoDTO {
    private Long id;
    private Long clienteId;
    private Long mesaId;
    private String clienteNombre;
    private EstadoPedido estado;
    private LocalDateTime creadoEn;
    private BigDecimal total;

    public PedidoDTO() {}

    public PedidoDTO(Long id, Long clienteId, Long mesaId, String clienteNombre, EstadoPedido estado, LocalDateTime creadoEn, BigDecimal total) {
        this.id = id;
        this.clienteId = clienteId;
        this.mesaId = mesaId;
        this.clienteNombre = clienteNombre;
        this.estado = estado;
        this.creadoEn = creadoEn;
        this.total = total;
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

    public EstadoPedido getEstado() {
        return estado;
    }

    public void setEstado(EstadoPedido estado) {
        this.estado = estado;
    }

    public LocalDateTime getCreadoEn() {
        return creadoEn;
    }

    public void setCreadoEn(LocalDateTime creadoEn) {
        this.creadoEn = creadoEn;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

}
