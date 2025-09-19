package com.example.uccexample.service.impl;

import com.example.uccexample.domain.dto.ClienteDTO;
import com.example.uccexample.infraestructure.crud.ClienteRepository;
import com.example.uccexample.infraestructure.mapper.ClienteMapper;
import com.example.uccexample.model.Cliente;
import com.example.uccexample.service.ClienteService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository repo;

    public ClienteServiceImpl(ClienteRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<ClienteDTO> findAll() {
        return repo.findAll()
                .stream()
                .map(ClienteMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ClienteDTO findById(Long id) {
        Optional<Cliente> opt = repo.findById(id);
        return opt.map(ClienteMapper::toDTO).orElse(null);
    }

    @Override
    public ClienteDTO save(ClienteDTO dto) {
        Cliente entity = ClienteMapper.toEntity(dto);
        Cliente saved = repo.save(entity);
        return ClienteMapper.toDTO(saved);
    }

    @Override
    public ClienteDTO update(Long id, ClienteDTO dto) {
        Optional<Cliente> opt = repo.findById(id);
        if (!opt.isPresent()) return null;

        Cliente entity = opt.get();
        // Actualiza SOLO los campos permitidos
        entity.setNombre(dto.getNombre());
        entity.setTelefono(dto.getTelefono());
        entity.setEmail(dto.getEmail());

        Cliente updated = repo.save(entity);
        return ClienteMapper.toDTO(updated);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }
}
