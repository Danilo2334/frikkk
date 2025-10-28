package com.example.uccexample.domain.service.impl;

import com.example.uccexample.domain.dto.PedidoDTO;
import com.example.uccexample.domain.irepository.IPedidoRepository;
import com.example.uccexample.domain.service.PedidoService;
import com.example.uccexample.infraestructure.mapper.PedidoMapper;
import com.example.uccexample.model.Cliente;
import com.example.uccexample.model.Mesa;
import com.example.uccexample.model.Pedido;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class PedidoServiceImpl implements PedidoService {

    private final IPedidoRepository repository;

    public PedidoServiceImpl(IPedidoRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<PedidoDTO> findAll() {
        return repository.findAll()
                .stream()
                .map(PedidoMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PedidoDTO findById(Long id) {
        Optional<Pedido> pedido = repository.findById(id);
        return pedido.map(PedidoMapper::toDTO).orElse(null);
    }

    @Override
    public PedidoDTO save(PedidoDTO dto) {
        Pedido entity = PedidoMapper.toEntity(dto);
        Pedido saved = repository.save(entity);
        return PedidoMapper.toDTO(saved);
    }

    @Override
    public PedidoDTO update(Long id, PedidoDTO dto) {
        Optional<Pedido> opt = repository.findById(id);
        if (!opt.isPresent()) {
            return null;
        }

        Pedido entity = opt.get();

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

        if (dto.getEstado() != null) {
            entity.setEstado(dto.getEstado());
        }

        if (dto.getCreadoEn() != null) {
            entity.setCreadoEn(dto.getCreadoEn());
        }

        if (dto.getTotal() != null) {
            entity.setTotal(dto.getTotal());
        }

        Pedido updated = repository.save(entity);
        return PedidoMapper.toDTO(updated);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
