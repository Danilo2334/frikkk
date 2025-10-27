package com.example.uccexample.infraestructure.mapper;

import com.example.uccexample.domain.dto.PedidoItemDTO;
import com.example.uccexample.model.Pedido;
import com.example.uccexample.model.PedidoItem;
import com.example.uccexample.model.Producto;

public class PedidoItemMapper {

    public static PedidoItemDTO toDTO(PedidoItem entity) {
        if (entity == null) {
            return null;
        }
        PedidoItemDTO dto = new PedidoItemDTO();
        dto.setId(entity.getId());
        dto.setPedidoId(entity.getPedido() != null ? entity.getPedido().getId() : null);
        dto.setProductoId(entity.getProducto() != null ? entity.getProducto().getId() : null);
        dto.setCantidad(entity.getCantidad());
        dto.setPrecioUnitario(entity.getPrecioUnitario());
        dto.setSubtotal(entity.getSubtotal());
        return dto;
    }

    public static PedidoItem toEntity(PedidoItemDTO dto) {
        if (dto == null) {
            return null;
        }
        PedidoItem item = new PedidoItem();
        item.setId(dto.getId());
        item.setCantidad(dto.getCantidad());
        item.setPrecioUnitario(dto.getPrecioUnitario());
        item.setSubtotal(dto.getSubtotal());
        if (dto.getPedidoId() != null) {
            Pedido pedido = new Pedido();
            pedido.setId(dto.getPedidoId());
            item.setPedido(pedido);
        }
        if (dto.getProductoId() != null) {
            Producto producto = new Producto();
            producto.setId(dto.getProductoId());
            item.setProducto(producto);
        }
        return item;
    }
}
