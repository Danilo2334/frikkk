package com.example.uccexample.repository;

import com.example.uccexample.domain.irepository.IPagoRepository;
import com.example.uccexample.infraestructure.crud.PagoCrud;
import com.example.uccexample.model.Pago;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public class PagoRepository implements IPagoRepository {

    private final PagoCrud crud;

    public PagoRepository(PagoCrud crud) {
        this.crud = crud;
    }

    @Override
    public List<Pago> findAll() {
        return crud.findAll();
    }

    @Override
    public Optional<Pago> findById(Long id) {
        return crud.findById(id);
    }

    @Override
    public Pago save(Pago pago) {
        return crud.save(pago);
    }

    @Override
    public void deleteById(Long id) {
        crud.deleteById(id);
    }
}
