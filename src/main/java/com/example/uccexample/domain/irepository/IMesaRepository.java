package com.example.uccexample.domain.irepository;

import com.example.uccexample.model.Mesa;
import java.util.List;
import java.util.Optional;

public interface IMesaRepository {
    List<Mesa> findAll();
    Optional<Mesa> findById(Long id);
    Mesa save(Mesa mesa);
    void deleteById(Long id);
}
