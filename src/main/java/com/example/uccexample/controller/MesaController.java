package com.example.uccexample.controller;

import com.example.uccexample.domain.dto.MesaDTO;
import com.example.uccexample.domain.service.MesaService;
import java.net.URI;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/mesas")
public class MesaController {

    private final MesaService service;

    public MesaController(MesaService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<MesaDTO>> list() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MesaDTO> get(@PathVariable Long id) {
        MesaDTO dto = service.findById(id);
        if (dto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<MesaDTO> create(@RequestBody MesaDTO dto) {
        MesaDTO saved = service.save(dto);
        return ResponseEntity.created(URI.create("/api/mesas/" + saved.getId())).body(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MesaDTO> update(@PathVariable Long id, @RequestBody MesaDTO dto) {
        MesaDTO updated = service.update(id, dto);
        if (updated == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        MesaDTO existing = service.findById(id);
        if (existing == null) {
            return ResponseEntity.notFound().build();
        }
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
