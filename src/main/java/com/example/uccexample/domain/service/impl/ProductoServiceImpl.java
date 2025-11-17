package com.example.uccexample.domain.service.impl;

import com.example.uccexample.domain.dto.ProductoDTO;
import com.example.uccexample.domain.service.ProductoService;
import com.example.uccexample.infraestructure.mapper.ProductoMapper;
import com.example.uccexample.model.Producto;
import com.example.uccexample.repository.ProductoRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class ProductoServiceImpl implements ProductoService {

    private final ProductoRepository repository;

    public ProductoServiceImpl(ProductoRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<ProductoDTO> findAll() {
        return repository.findAll()
                .stream()
                .map(ProductoMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ProductoDTO findById(Long id) {
        Optional<Producto> producto = repository.findById(id);
        return producto.map(ProductoMapper::toDTO).orElse(null);
    }

    @Override
    public ProductoDTO save(ProductoDTO dto) {
        Producto entity = ProductoMapper.toEntity(dto);
        Producto saved = repository.save(entity);
        return ProductoMapper.toDTO(saved);
    }

    @Override
    public ProductoDTO update(Long id, ProductoDTO dto) {
        Optional<Producto> opt = repository.findById(id);
        if (!opt.isPresent()) {
            return null;
        }

        Producto entity = opt.get();
        entity.setNombre(dto.getNombre());
        entity.setDescripcion(dto.getDescripcion());
        entity.setPrecio(dto.getPrecio());
        entity.setActivo(dto.getActivo() != null ? dto.getActivo() : entity.getActivo());

        Producto updated = repository.save(entity);
        return ProductoMapper.toDTO(updated);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
