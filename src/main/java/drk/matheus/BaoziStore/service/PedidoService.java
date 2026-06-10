package drk.matheus.BaoziStore.service;

import drk.matheus.BaoziStore.dto.input.CreatePedidoDTO;
import drk.matheus.BaoziStore.dto.input.CreateProdutoDTO;
import drk.matheus.BaoziStore.dto.output.ClienteResponseDTO;
import drk.matheus.BaoziStore.dto.output.PedidoResponseDTO;
import drk.matheus.BaoziStore.dto.output.ProdutoResponseDTO;
import drk.matheus.BaoziStore.entity.Cliente;
import drk.matheus.BaoziStore.entity.Pedido;
import drk.matheus.BaoziStore.entity.Produto;
import drk.matheus.BaoziStore.mapper.PedidoMapper;
import drk.matheus.BaoziStore.repository.ClienteRepository;
import drk.matheus.BaoziStore.repository.PedidoRepository;
import drk.matheus.BaoziStore.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {
    private final ProdutoRepository produtoRepository;
    private final ClienteRepository clienteRepository;
    private final PedidoRepository repository;
    private final PedidoMapper mapper;

    public PedidoService(ProdutoRepository produtoRepository, ClienteRepository clienteRepository, PedidoRepository repository, PedidoMapper mapper) {
        this.produtoRepository = produtoRepository;
        this.clienteRepository = clienteRepository;
        this.repository = repository;
        this.mapper = mapper;
    }


    public PedidoResponseDTO create(CreatePedidoDTO dto) {
        Cliente cliente = clienteRepository.findById(dto.clienteId()).orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        Produto produto = produtoRepository.findById(dto.produtoId()).orElseThrow((() -> new RuntimeException("Produto não encontrado")));
        Pedido p = mapper.toEntity(cliente, produto, dto);
        Pedido salvo = repository.save(p);

        return mapper.toResponse(salvo);
    }

    public List<PedidoResponseDTO> listAll() {
        return repository.findAll().stream().map(mapper::toResponse).toList();
    }

    public PedidoResponseDTO listById(Long id) {
        var pedidoEncontrado = repository.findById(id).orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
        return mapper.toResponse(pedidoEncontrado);
    }

    public void deleteById(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Pedido não encontrado");
        }

        repository.deleteById(id);
    }

    public PedidoResponseDTO updateById(Long id, CreatePedidoDTO dto) {

        var pedidoEncontrado = repository.findById(id).orElseThrow(() -> new RuntimeException("Pedido não encontrado"));

        Cliente cliente = clienteRepository.findById(dto.clienteId()).orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        Produto produto = produtoRepository.findById(dto.produtoId()).orElseThrow((() -> new RuntimeException("Produto não encontrado")));

        pedidoEncontrado.setCliente(cliente);
        pedidoEncontrado.setProduto(produto);
        pedidoEncontrado.setQuantidade(dto.quantidade());

        var salvo = repository.save(pedidoEncontrado);
        return mapper.toResponse(salvo);
    }
}
