package com.example.uccexample.domain.dto;

import com.example.uccexample.infraestructure.enums.EstadoPago;
import com.example.uccexample.infraestructure.enums.MetodoPago;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class PagoDTO {
    private Long id;
    private Long pedidoId;
    private MetodoPago metodo;
    private EstadoPago estado;
    private BigDecimal monto;
    private LocalDateTime pagadoEn;

    public PagoDTO() {}

    public PagoDTO(Long id, Long pedidoId, MetodoPago metodo, EstadoPago estado, BigDecimal monto, LocalDateTime pagadoEn) {
        this.id = id;
        this.pedidoId = pedidoId;
        this.metodo = metodo;
        this.estado = estado;
        this.monto = monto;
        this.pagadoEn = pagadoEn;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(Long pedidoId) {
        this.pedidoId = pedidoId;
    }

    public MetodoPago getMetodo() {
        return metodo;
    }

    public void setMetodo(MetodoPago metodo) {
        this.metodo = metodo;
    }

    public EstadoPago getEstado() {
        return estado;
    }

    public void setEstado(EstadoPago estado) {
        this.estado = estado;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public LocalDateTime getPagadoEn() {
        return pagadoEn;
    }

    public void setPagadoEn(LocalDateTime pagadoEn) {
        this.pagadoEn = pagadoEn;
    }
}
