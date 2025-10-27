package com.example.uccexample.repository;

import com.example.uccexample.domain.irepository.IPedidoItemRepository;
import com.example.uccexample.infraestructure.crud.PedidoItemCrud;
import com.example.uccexample.model.PedidoItem;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public class PedidoItemRepository implements IPedidoItemRepository {

    private final PedidoItemCrud crud;

    public PedidoItemRepository(PedidoItemCrud crud) {
        this.crud = crud;
    }

    @Override
    public List<PedidoItem> findAll() {
        return crud.findAll();
    }

    @Override
    public Optional<PedidoItem> findById(Long id) {
        return crud.findById(id);
    }

    @Override
    public PedidoItem save(PedidoItem item) {
        return crud.save(item);
    }

    @Override
    public void deleteById(Long id) {
        crud.deleteById(id);
    }
}
