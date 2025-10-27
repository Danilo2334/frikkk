package com.example.uccexample.domain.irepository;

import com.example.uccexample.model.Pago;
import java.util.List;
import java.util.Optional;

public interface IPagoRepository {
    List<Pago> findAll();
    Optional<Pago> findById(Long id);
    Pago save(Pago pago);
    void deleteById(Long id);
}
