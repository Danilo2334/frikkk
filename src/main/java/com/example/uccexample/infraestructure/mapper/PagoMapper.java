package com.example.uccexample.infraestructure.mapper;

import com.example.uccexample.domain.dto.PagoDTO;
import com.example.uccexample.model.Pago;
import com.example.uccexample.model.Pedido;

public class PagoMapper {

    public static PagoDTO toDTO(Pago entity) {
        if (entity == null) {
            return null;
        }
        PagoDTO dto = new PagoDTO();
        dto.setId(entity.getId());
        if (entity.getPedido() != null) {
            dto.setPedidoId(entity.getPedido().getId());
            dto.setPedidoClienteNombre(entity.getPedido().getCliente() != null ? entity.getPedido().getCliente().getNombre() : null);
            dto.setPedidoTotal(entity.getPedido().getTotal());
        } else {
            dto.setPedidoId(null);
            dto.setPedidoClienteNombre(null);
            dto.setPedidoTotal(null);
        }
        dto.setMetodo(entity.getMetodo());
        dto.setEstado(entity.getEstado());
        dto.setMonto(entity.getMonto());
        dto.setPagadoEn(entity.getPagadoEn());
        return dto;
    }

    public static Pago toEntity(PagoDTO dto) {
        if (dto == null) {
            return null;
        }
        Pago pago = new Pago();
        pago.setId(dto.getId());
        pago.setMetodo(dto.getMetodo());
        pago.setEstado(dto.getEstado());
        pago.setMonto(dto.getMonto());
        if (dto.getPagadoEn() != null) {
            pago.setPagadoEn(dto.getPagadoEn());
        }
        if (dto.getPedidoId() != null) {
            Pedido pedido = new Pedido();
            pedido.setId(dto.getPedidoId());
            pago.setPedido(pedido);
        } else {
            pago.setPedido(null);
        }
        return pago;
    }
}
