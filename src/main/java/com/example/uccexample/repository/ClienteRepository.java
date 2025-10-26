package com.example.uccexample.repository;

import com.example.uccexample.domain.irepository.IClienteRepository;
import com.example.uccexample.infraestructure.crud.ClienteCrud;
import com.example.uccexample.model.Cliente;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public class ClienteRepository implements IClienteRepository {

    private final ClienteCrud crud;

    public ClienteRepository(ClienteCrud crud) {
        this.crud = crud;
    }

    @Override
    public List<Cliente> findAll() {
        return crud.findAll();
    }

    @Override
    public Optional<Cliente> findById(Long id) {
        return crud.findById(id);
    }

    @Override
    public Cliente save(Cliente cliente) {
        return crud.save(cliente);
    }

    @Override
    public void deleteById(Long id) {
        crud.deleteById(id);
    }
}
