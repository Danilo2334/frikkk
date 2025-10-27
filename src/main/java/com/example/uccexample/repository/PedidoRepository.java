package com.example.uccexample.repository;

import com.example.uccexample.domain.irepository.IPedidoRepository;
import com.example.uccexample.infraestructure.crud.PedidoCrud;
import com.example.uccexample.model.Pedido;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public class PedidoRepository implements IPedidoRepository {

    private final PedidoCrud crud;

    public PedidoRepository(PedidoCrud crud) {
        this.crud = crud;
    }

    @Override
    public List<Pedido> findAll() {
        return crud.findAll();
    }

    @Override
    public Optional<Pedido> findById(Long id) {
        return crud.findById(id);
    }

    @Override
    public Pedido save(Pedido pedido) {
        return crud.save(pedido);
    }

    @Override
    public void deleteById(Long id) {
        crud.deleteById(id);
    }
}
