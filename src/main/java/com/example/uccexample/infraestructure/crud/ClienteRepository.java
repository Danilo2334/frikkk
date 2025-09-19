package com.example.uccexample.infraestructure.crud;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.uccexample.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> { }
