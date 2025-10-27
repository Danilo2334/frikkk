package com.example.uccexample.domain.irepository;

import com.example.uccexample.model.Pedido;
import java.util.List;
import java.util.Optional;

public interface IPedidoRepository {
    List<Pedido> findAll();
    Optional<Pedido> findById(Long id);
    Pedido save(Pedido pedido);
    void deleteById(Long id);
}
