package com.example.uccexample.repository;

import com.example.uccexample.domain.irepository.IProductoRepository;
import com.example.uccexample.infraestructure.crud.ProductoCrud;
import com.example.uccexample.model.Producto;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public class ProductoRepository implements IProductoRepository {

    private final ProductoCrud crud;

    public ProductoRepository(ProductoCrud crud) {
        this.crud = crud;
    }

    @Override
    public List<Producto> findAll() {
        return crud.findAll();
    }

    @Override
    public Optional<Producto> findById(Long id) {
        return crud.findById(id);
    }

    @Override
    public Producto save(Producto producto) {
        return crud.save(producto);
    }

    @Override
    public void deleteById(Long id) {
        crud.deleteById(id);
    }
}
