package com.example.uccexample.infraestructure.crud;

import com.example.uccexample.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteCrud extends JpaRepository<Cliente, Long> { }
