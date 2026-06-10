package drk.matheus.BaoziStore.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import drk.matheus.BaoziStore.dto.input.CreatePedidoDTO;
import drk.matheus.BaoziStore.dto.output.PedidoResponseDTO;
import drk.matheus.BaoziStore.service.PedidoService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/pedido")
public class PedidoController {
    private final PedidoService service;

    public PedidoController(PedidoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<PedidoResponseDTO> create(@RequestBody @Valid CreatePedidoDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto));
    }

    @GetMapping
    public List<PedidoResponseDTO> listAll() {
        return service.listAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoResponseDTO> listById(@PathVariable Long id) {return ResponseEntity.ok(service.listById(id));}

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<PedidoResponseDTO> updateById(@PathVariable Long id, @RequestBody @Valid CreatePedidoDTO dto) {
        return ResponseEntity.ok().body(service.updateById(id, dto));
    }
}

