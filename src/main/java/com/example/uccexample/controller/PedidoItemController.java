package com.example.uccexample.controller;

import com.example.uccexample.domain.dto.PedidoItemDTO;
import com.example.uccexample.domain.service.PedidoItemService;
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
@RequestMapping("/api/pedido-items")
public class PedidoItemController {

    private final PedidoItemService service;

    public PedidoItemController(PedidoItemService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<PedidoItemDTO>> list() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoItemDTO> get(@PathVariable Long id) {
        PedidoItemDTO dto = service.findById(id);
        if (dto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<PedidoItemDTO> create(@RequestBody PedidoItemDTO dto) {
        PedidoItemDTO saved = service.save(dto);
        return ResponseEntity.created(URI.create("/api/pedido-items/" + saved.getId())).body(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PedidoItemDTO> update(@PathVariable Long id, @RequestBody PedidoItemDTO dto) {
        PedidoItemDTO updated = service.update(id, dto);
        if (updated == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        PedidoItemDTO existing = service.findById(id);
        if (existing == null) {
            return ResponseEntity.notFound().build();
        }
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
