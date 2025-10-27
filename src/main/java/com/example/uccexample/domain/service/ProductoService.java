package com.example.uccexample.domain.service;

import com.example.uccexample.domain.dto.ProductoDTO;
import java.util.List;

public interface ProductoService {
    List<ProductoDTO> findAll();
    ProductoDTO findById(Long id);
    ProductoDTO save(ProductoDTO dto);
    ProductoDTO update(Long id, ProductoDTO dto);
    void delete(Long id);
}
