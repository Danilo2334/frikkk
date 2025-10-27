package com.example.uccexample.infraestructure.crud;

import com.example.uccexample.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoCrud extends JpaRepository<Producto, Long> { }
