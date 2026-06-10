package drk.matheus.BaoziStore.service;

import drk.matheus.BaoziStore.dto.input.CreateProdutoDTO;
import drk.matheus.BaoziStore.dto.output.PedidoResponseDTO;
import drk.matheus.BaoziStore.dto.output.ProdutoResponseDTO;
import drk.matheus.BaoziStore.entity.Produto;
import drk.matheus.BaoziStore.mapper.ProdutoMapper;
import drk.matheus.BaoziStore.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {
    private final ProdutoRepository repository;
    private final ProdutoMapper mapper;

    public ProdutoService(ProdutoRepository repository, ProdutoMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public ProdutoResponseDTO create(CreateProdutoDTO dto) {
        Produto p = mapper.toEntity(dto);
        Produto salvo = repository.save(p);

        return mapper.toResponse(salvo);
    }

    public List<ProdutoResponseDTO> listAll() {
        return repository.findAll().stream().map(mapper::toResponse).toList();
    }

    public ProdutoResponseDTO listById(Long id) {
        var produtoEncontrado = repository.findById(id).orElseThrow(() -> new RuntimeException("Produto não encontrado"));
        return mapper.toResponse(produtoEncontrado);
    }

    public void deleteById(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Produto não encontrado");
        }

       repository.deleteById(id);
    }

    public ProdutoResponseDTO updateById(Long id, CreateProdutoDTO dto) {

        var produtoEncontrado = repository.findById(id).orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        produtoEncontrado.setNome(dto.nome());
        produtoEncontrado.setPreco(dto.preco());
        produtoEncontrado.setEstoque(dto.estoque());

        var salvo = repository.save(produtoEncontrado);
        return mapper.toResponse(salvo);
    }
}
