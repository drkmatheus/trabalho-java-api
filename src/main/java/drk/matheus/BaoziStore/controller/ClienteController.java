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

import drk.matheus.BaoziStore.dto.input.CreateClienteDTO;
import drk.matheus.BaoziStore.dto.output.ClienteResponseDTO;
import drk.matheus.BaoziStore.service.ClienteService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    private final ClienteService service;

    public ClienteController(ClienteService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ClienteResponseDTO> create(@RequestBody @Valid CreateClienteDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto));
    }

    @GetMapping
    public List<ClienteResponseDTO> listAll() {
        return service.listAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteResponseDTO> listById(@PathVariable Long id) {return ResponseEntity.ok(service.listById(id));}

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteResponseDTO> updateById(@PathVariable Long id, @RequestBody @Valid CreateClienteDTO dto) {
        return ResponseEntity.ok().body(service.updateById(id, dto));
    }
}
