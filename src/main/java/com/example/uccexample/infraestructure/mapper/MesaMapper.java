package com.example.uccexample.infraestructure.mapper;

import com.example.uccexample.domain.dto.MesaDTO;
import com.example.uccexample.model.Mesa;

public class MesaMapper {

    public static MesaDTO toDTO(Mesa entity) {
        if (entity == null) return null;
        MesaDTO dto = new MesaDTO();
        dto.setId(entity.getId());
        dto.setNumero(entity.getNumero());
        dto.setCapacidad(entity.getCapacidad());
        dto.setZona(entity.getZona());
        return dto;
    }

    public static Mesa toEntity(MesaDTO dto) {
        if (dto == null) return null;
        Mesa mesa = new Mesa();
        mesa.setId(dto.getId());
        mesa.setNumero(dto.getNumero());
        mesa.setCapacidad(dto.getCapacidad());
        mesa.setZona(dto.getZona());
        return mesa;
    }
}
