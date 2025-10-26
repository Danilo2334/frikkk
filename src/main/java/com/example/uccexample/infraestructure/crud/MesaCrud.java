package com.example.uccexample.infraestructure.crud;

import com.example.uccexample.model.Mesa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MesaCrud extends JpaRepository<Mesa, Long> { }
