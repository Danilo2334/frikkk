package com.example.uccexample.infraestructure.model;

import jakarta.persistence.*;

@Entity
@Table(name = "clientes")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 120)
    private String nombre;

    @Column(length = 120, unique = true)
    private String email;

    @Column(length = 20)
    private String telefono;

    // getters y setters
}
