package com.example.uccexample.infraestructure.mapper;

import com.example.uccexample.domain.dto.ReservaDTO;
import com.example.uccexample.model.Cliente;
import com.example.uccexample.model.Mesa;
import com.example.uccexample.model.Reserva;

public class ReservaMapper {

    public static ReservaDTO toDTO(Reserva entity) {
        if (entity == null) {
            return null;
        }
        ReservaDTO dto = new ReservaDTO();
        dto.setId(entity.getId());
        dto.setClienteId(entity.getCliente() != null ? entity.getCliente().getId() : null);
        dto.setMesaId(entity.getMesa() != null ? entity.getMesa().getId() : null);
        dto.setFechaHora(entity.getFechaHora());
        dto.setPersonas(entity.getPersonas());
        dto.setEstado(entity.getEstado());
        return dto;
    }

    public static Reserva toEntity(ReservaDTO dto) {
        if (dto == null) {
            return null;
        }
        Reserva reserva = new Reserva();
        reserva.setId(dto.getId());
        reserva.setFechaHora(dto.getFechaHora());
        reserva.setPersonas(dto.getPersonas());
        if (dto.getEstado() != null) {
            reserva.setEstado(dto.getEstado());
        }
        if (dto.getClienteId() != null) {
            Cliente cliente = new Cliente();
            cliente.setId(dto.getClienteId());
            reserva.setCliente(cliente);
        } else {
            reserva.setCliente(null);
        }
        if (dto.getMesaId() != null) {
            Mesa mesa = new Mesa();
            mesa.setId(dto.getMesaId());
            reserva.setMesa(mesa);
        } else {
            reserva.setMesa(null);
        }
        return reserva;
    }
}
