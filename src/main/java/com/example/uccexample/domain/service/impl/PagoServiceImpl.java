package com.example.uccexample.domain.service.impl;

import com.example.uccexample.domain.dto.PagoDTO;
import com.example.uccexample.domain.irepository.IPagoRepository;
import com.example.uccexample.domain.service.PagoService;
import com.example.uccexample.infraestructure.mapper.PagoMapper;
import com.example.uccexample.model.Pago;
import com.example.uccexample.model.Pedido;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class PagoServiceImpl implements PagoService {

    private final IPagoRepository repository;

    public PagoServiceImpl(IPagoRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<PagoDTO> findAll() {
        return repository.findAll()
                .stream()
                .map(PagoMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PagoDTO findById(Long id) {
        Optional<Pago> pago = repository.findById(id);
        return pago.map(PagoMapper::toDTO).orElse(null);
    }

    @Override
    public PagoDTO save(PagoDTO dto) {
        Pago entity = PagoMapper.toEntity(dto);
        Pago saved = repository.save(entity);
        return PagoMapper.toDTO(saved);
    }

    @Override
    public PagoDTO update(Long id, PagoDTO dto) {
        Optional<Pago> opt = repository.findById(id);
        if (!opt.isPresent()) {
            return null;
        }

        Pago entity = opt.get();
        entity.setMetodo(dto.getMetodo());
        entity.setEstado(dto.getEstado());
        entity.setMonto(dto.getMonto());
        if (dto.getPagadoEn() != null) {
            entity.setPagadoEn(dto.getPagadoEn());
        }

        if (dto.getPedidoId() != null) {
            Pedido pedido = new Pedido();
            pedido.setId(dto.getPedidoId());
            entity.setPedido(pedido);
        } else {
            entity.setPedido(null);
        }

        Pago updated = repository.save(entity);
        return PagoMapper.toDTO(updated);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
