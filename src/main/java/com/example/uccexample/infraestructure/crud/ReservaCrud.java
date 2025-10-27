package com.example.uccexample.infraestructure.crud;

import com.example.uccexample.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservaCrud extends JpaRepository<Reserva, Long> { }
