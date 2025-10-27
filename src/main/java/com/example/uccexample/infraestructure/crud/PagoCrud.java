package com.example.uccexample.infraestructure.crud;

import com.example.uccexample.model.Pago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagoCrud extends JpaRepository<Pago, Long> { }
