package com.example.uccexample.domain.service;

import com.example.uccexample.domain.dto.PagoDTO;
import java.util.List;

public interface PagoService {
    List<PagoDTO> findAll();
    PagoDTO findById(Long id);
    PagoDTO save(PagoDTO dto);
    PagoDTO update(Long id, PagoDTO dto);
    void delete(Long id);
}
