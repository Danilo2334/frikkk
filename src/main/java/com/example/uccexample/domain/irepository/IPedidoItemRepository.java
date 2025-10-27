package com.example.uccexample.domain.irepository;

import com.example.uccexample.model.PedidoItem;
import java.util.List;
import java.util.Optional;

public interface IPedidoItemRepository {
    List<PedidoItem> findAll();
    Optional<PedidoItem> findById(Long id);
    PedidoItem save(PedidoItem item);
    void deleteById(Long id);
}
