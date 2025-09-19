package com.example.uccexample.service;

import com.example.uccexample.domain.dto.ClienteDTO;
import java.util.List;

public interface ClienteService {
    List<ClienteDTO> findAll();
    ClienteDTO findById(Long id);     // ← byId
    ClienteDTO save(ClienteDTO dto);
    ClienteDTO update(Long id, ClienteDTO dto);
    void delete(Long id);              // ← delete
}
