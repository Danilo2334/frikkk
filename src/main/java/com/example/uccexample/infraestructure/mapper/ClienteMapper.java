package com.example.uccexample.infraestructure.mapper;


import com.example.uccexample.domain.dto.ClienteDTO;
import com.example.uccexample.model.Cliente;

public class ClienteMapper {

    public static ClienteDTO toDTO(Cliente entity) {
        if (entity == null) return null;
        ClienteDTO dto = new ClienteDTO();
        dto.setId(entity.getId());
        dto.setNombre(entity.getNombre());
        dto.setTelefono(entity.getTelefono());
        dto.setEmail(entity.getEmail());
        return dto;
    }

    public static Cliente toEntity(ClienteDTO dto) {
        if (dto == null) return null;
        Cliente c = new Cliente();
        c.setId(dto.getId());
        c.setNombre(dto.getNombre());
        c.setTelefono(dto.getTelefono());
        c.setEmail(dto.getEmail());
        return c;
    }
}
