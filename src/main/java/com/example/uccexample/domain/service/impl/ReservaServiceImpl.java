package com.example.uccexample.domain.service.impl;

import com.example.uccexample.domain.dto.ReservaDTO;
import com.example.uccexample.domain.irepository.IReservaRepository;
import com.example.uccexample.domain.service.ReservaService;
import com.example.uccexample.infraestructure.mapper.ReservaMapper;
import com.example.uccexample.model.Cliente;
import com.example.uccexample.model.Mesa;
import com.example.uccexample.model.Reserva;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class ReservaServiceImpl implements ReservaService {

    private final IReservaRepository repository;

    public ReservaServiceImpl(IReservaRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<ReservaDTO> findAll() {
        return repository.findAll()
                .stream()
                .map(ReservaMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ReservaDTO findById(Long id) {
        Optional<Reserva> reserva = repository.findById(id);
        return reserva.map(ReservaMapper::toDTO).orElse(null);
    }

    @Override
    public ReservaDTO save(ReservaDTO dto) {
        Reserva entity = ReservaMapper.toEntity(dto);
        Reserva saved = repository.save(entity);
        return ReservaMapper.toDTO(saved);
    }

    @Override
    public ReservaDTO update(Long id, ReservaDTO dto) {
        Optional<Reserva> opt = repository.findById(id);
        if (!opt.isPresent()) {
            return null;
        }

        Reserva entity = opt.get();
        entity.setFechaHora(dto.getFechaHora());
        entity.setPersonas(dto.getPersonas());
        if (dto.getEstado() != null) {
            entity.setEstado(dto.getEstado());
        }

        if (dto.getClienteId() != null) {
            Cliente cliente = new Cliente();
            cliente.setId(dto.getClienteId());
            entity.setCliente(cliente);
        } else {
            entity.setCliente(null);
        }

        if (dto.getMesaId() != null) {
            Mesa mesa = new Mesa();
            mesa.setId(dto.getMesaId());
            entity.setMesa(mesa);
        } else {
            entity.setMesa(null);
        }

        Reserva updated = repository.save(entity);
        return ReservaMapper.toDTO(updated);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
