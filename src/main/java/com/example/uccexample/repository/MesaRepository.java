package com.example.uccexample.repository;

import com.example.uccexample.domain.irepository.IMesaRepository;
import com.example.uccexample.infraestructure.crud.MesaCrud;
import com.example.uccexample.model.Mesa;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public class MesaRepository implements IMesaRepository {

    private final MesaCrud crud;

    public MesaRepository(MesaCrud crud) {
        this.crud = crud;
    }

    @Override
    public List<Mesa> findAll() {
        return crud.findAll();
    }

    @Override
    public Optional<Mesa> findById(Long id) {
        return crud.findById(id);
    }

    @Override
    public Mesa save(Mesa mesa) {
        return crud.save(mesa);
    }

    @Override
    public void deleteById(Long id) {
        crud.deleteById(id);
    }
}
