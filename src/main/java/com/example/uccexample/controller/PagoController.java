package com.example.uccexample.controller;

import com.example.uccexample.domain.dto.PagoDTO;
import com.example.uccexample.domain.service.PagoService;
import java.net.URI;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pagos")
public class PagoController {

    private final PagoService service;

    public PagoController(PagoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<PagoDTO>> list() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PagoDTO> get(@PathVariable Long id) {
        PagoDTO dto = service.findById(id);
        if (dto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<PagoDTO> create(@RequestBody PagoDTO dto) {
        PagoDTO saved = service.save(dto);
        return ResponseEntity.created(URI.create("/api/pagos/" + saved.getId())).body(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PagoDTO> update(@PathVariable Long id, @RequestBody PagoDTO dto) {
        PagoDTO updated = service.update(id, dto);
        if (updated == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        PagoDTO existing = service.findById(id);
        if (existing == null) {
            return ResponseEntity.notFound().build();
        }
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
