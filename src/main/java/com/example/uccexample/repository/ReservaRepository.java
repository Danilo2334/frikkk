package com.example.uccexample.repository;

import com.example.uccexample.domain.irepository.IReservaRepository;
import com.example.uccexample.infraestructure.crud.ReservaCrud;
import com.example.uccexample.model.Reserva;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public class ReservaRepository implements IReservaRepository {

    private final ReservaCrud crud;

    public ReservaRepository(ReservaCrud crud) {
        this.crud = crud;
    }

    @Override
    public List<Reserva> findAll() {
        return crud.findAll();
    }

    @Override
    public Optional<Reserva> findById(Long id) {
        return crud.findById(id);
    }

    @Override
    public Reserva save(Reserva reserva) {
        return crud.save(reserva);
    }

    @Override
    public void deleteById(Long id) {
        crud.deleteById(id);
    }
}
