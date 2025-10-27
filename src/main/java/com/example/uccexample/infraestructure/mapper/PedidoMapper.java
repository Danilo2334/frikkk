package com.example.uccexample.infraestructure.mapper;

import com.example.uccexample.domain.dto.PedidoDTO;
import com.example.uccexample.domain.dto.PedidoItemDTO;
import com.example.uccexample.model.Cliente;
import com.example.uccexample.model.Mesa;
import com.example.uccexample.model.Pedido;
import com.example.uccexample.model.PedidoItem;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class PedidoMapper {

    public static PedidoDTO toDTO(Pedido entity) {
        if (entity == null) {
            return null;
        }
        PedidoDTO dto = new PedidoDTO();
        dto.setId(entity.getId());
        dto.setClienteId(entity.getCliente() != null ? entity.getCliente().getId() : null);
        dto.setMesaId(entity.getMesa() != null ? entity.getMesa().getId() : null);
        dto.setEstado(entity.getEstado());
        dto.setCreadoEn(entity.getCreadoEn());
        dto.setTotal(entity.getTotal());
        List<PedidoItem> items = entity.getItems();
        if (items == null || items.isEmpty()) {
            dto.setItems(Collections.emptyList());
        } else {
            dto.setItems(items.stream()
                    .map(PedidoItemMapper::toDTO)
                    .collect(Collectors.toList()));
        }
        return dto;
    }

    public static Pedido toEntity(PedidoDTO dto) {
        if (dto == null) {
            return null;
        }
        Pedido pedido = new Pedido();
        pedido.setId(dto.getId());

        if (dto.getClienteId() != null) {
            Cliente cliente = new Cliente();
            cliente.setId(dto.getClienteId());
            pedido.setCliente(cliente);
        } else {
            pedido.setCliente(null);
        }

        if (dto.getMesaId() != null) {
            Mesa mesa = new Mesa();
            mesa.setId(dto.getMesaId());
            pedido.setMesa(mesa);
        } else {
            pedido.setMesa(null);
        }

        if (dto.getEstado() != null) {
            pedido.setEstado(dto.getEstado());
        }

        if (dto.getCreadoEn() != null) {
            pedido.setCreadoEn(dto.getCreadoEn());
        }

        if (dto.getTotal() != null) {
            pedido.setTotal(dto.getTotal());
        }

        pedido.getItems().clear();
        if (dto.getItems() != null) {
            for (PedidoItemDTO itemDTO : dto.getItems()) {
                PedidoItem item = PedidoItemMapper.toEntity(itemDTO);
                pedido.addItem(item);
            }
        }

        return pedido;
    }
}
