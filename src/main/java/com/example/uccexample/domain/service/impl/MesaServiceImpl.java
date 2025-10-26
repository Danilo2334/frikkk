package com.example.uccexample.domain.service.impl;

import com.example.uccexample.domain.dto.MesaDTO;
import com.example.uccexample.domain.irepository.IMesaRepository;
import com.example.uccexample.domain.service.MesaService;
import com.example.uccexample.infraestructure.mapper.MesaMapper;
import com.example.uccexample.model.Mesa;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class MesaServiceImpl implements MesaService {

    private final IMesaRepository repository;

    public MesaServiceImpl(IMesaRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<MesaDTO> findAll() {
        return repository.findAll()
                .stream()
                .map(MesaMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public MesaDTO findById(Long id) {
        Optional<Mesa> mesa = repository.findById(id);
        return mesa.map(MesaMapper::toDTO).orElse(null);
    }

    @Override
    public MesaDTO save(MesaDTO dto) {
        Mesa entity = MesaMapper.toEntity(dto);
        Mesa saved = repository.save(entity);
        return MesaMapper.toDTO(saved);
    }

    @Override
    public MesaDTO update(Long id, MesaDTO dto) {
        Optional<Mesa> mesaOpt = repository.findById(id);
        if (!mesaOpt.isPresent()) {
            return null;
        }

        Mesa entity = mesaOpt.get();
        entity.setNumero(dto.getNumero());
        entity.setCapacidad(dto.getCapacidad());
        entity.setZona(dto.getZona());

        Mesa updated = repository.save(entity);
        return MesaMapper.toDTO(updated);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
