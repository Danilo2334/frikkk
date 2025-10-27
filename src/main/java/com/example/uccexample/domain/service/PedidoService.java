package com.example.uccexample.domain.service;

import com.example.uccexample.domain.dto.PedidoDTO;
import java.util.List;

public interface PedidoService {
    List<PedidoDTO> findAll();
    PedidoDTO findById(Long id);
    PedidoDTO save(PedidoDTO dto);
    PedidoDTO update(Long id, PedidoDTO dto);
    void delete(Long id);
}
