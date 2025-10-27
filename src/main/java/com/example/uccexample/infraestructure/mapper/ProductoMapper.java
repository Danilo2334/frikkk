package com.example.uccexample.infraestructure.mapper;

import com.example.uccexample.domain.dto.ProductoDTO;
import com.example.uccexample.model.Producto;

public class ProductoMapper {

    public static ProductoDTO toDTO(Producto entity) {
        if (entity == null) {
            return null;
        }
        ProductoDTO dto = new ProductoDTO();
        dto.setId(entity.getId());
        dto.setNombre(entity.getNombre());
        dto.setDescripcion(entity.getDescripcion());
        dto.setPrecio(entity.getPrecio());
        dto.setActivo(entity.getActivo());
        return dto;
    }

    public static Producto toEntity(ProductoDTO dto) {
        if (dto == null) {
            return null;
        }
        Producto producto = new Producto();
        producto.setId(dto.getId());
        producto.setNombre(dto.getNombre());
        producto.setDescripcion(dto.getDescripcion());
        producto.setPrecio(dto.getPrecio());
        producto.setActivo(dto.getActivo() != null ? dto.getActivo() : Boolean.TRUE);
        return producto;
    }
}
