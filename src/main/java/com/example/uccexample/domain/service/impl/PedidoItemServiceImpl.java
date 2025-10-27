package com.example.uccexample.domain.service.impl;

import com.example.uccexample.domain.dto.PedidoItemDTO;
import com.example.uccexample.domain.irepository.IPedidoItemRepository;
import com.example.uccexample.domain.service.PedidoItemService;
import com.example.uccexample.infraestructure.mapper.PedidoItemMapper;
import com.example.uccexample.model.Pedido;
import com.example.uccexample.model.PedidoItem;
import com.example.uccexample.model.Producto;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class PedidoItemServiceImpl implements PedidoItemService {

    private final IPedidoItemRepository repository;

    public PedidoItemServiceImpl(IPedidoItemRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<PedidoItemDTO> findAll() {
        return repository.findAll()
                .stream()
                .map(PedidoItemMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PedidoItemDTO findById(Long id) {
        Optional<PedidoItem> item = repository.findById(id);
        return item.map(PedidoItemMapper::toDTO).orElse(null);
    }

    @Override
    public PedidoItemDTO save(PedidoItemDTO dto) {
        PedidoItem entity = PedidoItemMapper.toEntity(dto);
        PedidoItem saved = repository.save(entity);
        return PedidoItemMapper.toDTO(saved);
    }

    @Override
    public PedidoItemDTO update(Long id, PedidoItemDTO dto) {
        Optional<PedidoItem> opt = repository.findById(id);
        if (!opt.isPresent()) {
            return null;
        }

        PedidoItem entity = opt.get();
        entity.setCantidad(dto.getCantidad());
        entity.setPrecioUnitario(dto.getPrecioUnitario());
        entity.setSubtotal(dto.getSubtotal());

        if (dto.getPedidoId() != null) {
            Pedido pedido = new Pedido();
            pedido.setId(dto.getPedidoId());
            entity.setPedido(pedido);
        } else {
            entity.setPedido(null);
        }

        if (dto.getProductoId() != null) {
            Producto producto = new Producto();
            producto.setId(dto.getProductoId());
            entity.setProducto(producto);
        } else {
            entity.setProducto(null);
        }

        PedidoItem updated = repository.save(entity);
        return PedidoItemMapper.toDTO(updated);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
