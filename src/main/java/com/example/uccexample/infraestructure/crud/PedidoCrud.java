package com.example.uccexample.infraestructure.crud;

import com.example.uccexample.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoCrud extends JpaRepository<Pedido, Long> { }
