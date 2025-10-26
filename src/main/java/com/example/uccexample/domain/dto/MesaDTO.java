package com.example.uccexample.domain.dto;

public class MesaDTO {
    private Long id;
    private Integer numero;
    private Integer capacidad;
    private String zona;

    public MesaDTO() {}

    public MesaDTO(Long id, Integer numero, Integer capacidad, String zona) {
        this.id = id;
        this.numero = numero;
        this.capacidad = capacidad;
        this.zona = zona;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }
}
