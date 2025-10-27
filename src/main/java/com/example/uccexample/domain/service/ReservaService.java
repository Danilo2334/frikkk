package com.example.uccexample.domain.service;

import com.example.uccexample.domain.dto.ReservaDTO;
import java.util.List;

public interface ReservaService {
    List<ReservaDTO> findAll();
    ReservaDTO findById(Long id);
    ReservaDTO save(ReservaDTO dto);
    ReservaDTO update(Long id, ReservaDTO dto);
    void delete(Long id);
}
