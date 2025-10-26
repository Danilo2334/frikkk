package com.example.uccexample.domain.irepository;

import com.example.uccexample.model.Cliente;
import java.util.List;
import java.util.Optional;

public interface IClienteRepository {
    List<Cliente> findAll();
    Optional<Cliente> findById(Long id);
    Cliente save(Cliente cliente);
    void deleteById(Long id);
}
