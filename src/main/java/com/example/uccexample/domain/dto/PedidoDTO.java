package com.example.uccexample.domain.dto;

import com.example.uccexample.infraestructure.enums.EstadoPedido;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class PedidoDTO {
    private Long id;
    private Long clienteId;
    private Long mesaId;
    private EstadoPedido estado;
    private LocalDateTime creadoEn;
    private BigDecimal total;
    private List<PedidoItemDTO> items = new ArrayList<>();

    public PedidoDTO() {}

    public PedidoDTO(Long id, Long clienteId, Long mesaId, EstadoPedido estado, LocalDateTime creadoEn, BigDecimal total, List<PedidoItemDTO> items) {
        this.id = id;
        this.clienteId = clienteId;
        this.mesaId = mesaId;
        this.estado = estado;
        this.creadoEn = creadoEn;
        this.total = total;
        if (items != null) {
            this.items = items;
        }
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

    public List<PedidoItemDTO> getItems() {
        return items;
    }

    public void setItems(List<PedidoItemDTO> items) {
        this.items = items != null ? items : new ArrayList<>();
    }
}
