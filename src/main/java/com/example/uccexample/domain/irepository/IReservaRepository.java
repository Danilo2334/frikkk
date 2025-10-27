package com.example.uccexample.domain.irepository;

import com.example.uccexample.model.Reserva;
import java.util.List;
import java.util.Optional;

public interface IReservaRepository {
    List<Reserva> findAll();
    Optional<Reserva> findById(Long id);
    Reserva save(Reserva reserva);
    void deleteById(Long id);
}
