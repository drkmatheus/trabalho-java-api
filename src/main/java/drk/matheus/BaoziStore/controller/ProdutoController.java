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

import drk.matheus.BaoziStore.dto.input.CreateProdutoDTO;
import drk.matheus.BaoziStore.dto.output.ProdutoResponseDTO;
import drk.matheus.BaoziStore.service.ProdutoService;
import jakarta.validation.Valid;

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
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoResponseDTO> updateById( @PathVariable Long id, @RequestBody @Valid CreateProdutoDTO dto) {
        return ResponseEntity.ok().body(service.updateById(id, dto));
    }
}
