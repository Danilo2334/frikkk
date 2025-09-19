package com.example.uccexample.controller;

import com.example.uccexample.domain.dto.ClienteDTO;
import com.example.uccexample.service.ClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    private final ClienteService service;

    public ClienteController(ClienteService service) { this.service = service; }

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> list() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}") // ← byId
    public ResponseEntity<ClienteDTO> get(@PathVariable Long id) {
        ClienteDTO dto = service.findById(id);
        if (dto == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<ClienteDTO> create(@RequestBody ClienteDTO body) {
        ClienteDTO saved = service.save(body);
        return ResponseEntity.created(URI.create("/api/clientes/" + saved.getId())).body(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteDTO> update(@PathVariable Long id, @RequestBody ClienteDTO body) {
        ClienteDTO updated = service.update(id, body);
        if (updated == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}") // ← delete
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        ClienteDTO found = service.findById(id);
        if (found == null) return ResponseEntity.notFound().build();
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
