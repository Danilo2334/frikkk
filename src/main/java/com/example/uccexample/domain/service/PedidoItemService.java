package com.example.uccexample.domain.service;

import com.example.uccexample.domain.dto.PedidoItemDTO;
import java.util.List;

public interface PedidoItemService {
    List<PedidoItemDTO> findAll();
    PedidoItemDTO findById(Long id);
    PedidoItemDTO save(PedidoItemDTO dto);
    PedidoItemDTO update(Long id, PedidoItemDTO dto);
    void delete(Long id);
}
