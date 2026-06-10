package drk.matheus.BaoziStore.controller;

import drk.matheus.BaoziStore.dto.input.CreateProdutoDTO;
import drk.matheus.BaoziStore.dto.output.ClienteResponseDTO;
import drk.matheus.BaoziStore.dto.output.ProdutoResponseDTO;
import drk.matheus.BaoziStore.service.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
    private final ProdutoService service;

    public ProdutoController(ProdutoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ProdutoResponseDTO> create(@RequestBody @Valid CreateProdutoDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto));
    }

    @GetMapping
    public List<ProdutoResponseDTO> listAll() {
        return service.listAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoResponseDTO> listById(@PathVariable Long id) {return ResponseEntity.ok(service.listById(id));}

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
