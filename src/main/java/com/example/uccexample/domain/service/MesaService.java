package com.example.uccexample.domain.service;

import com.example.uccexample.domain.dto.MesaDTO;
import java.util.List;

public interface MesaService {
    List<MesaDTO> findAll();
    MesaDTO findById(Long id);
    MesaDTO save(MesaDTO dto);
    MesaDTO update(Long id, MesaDTO dto);
    void delete(Long id);
}
