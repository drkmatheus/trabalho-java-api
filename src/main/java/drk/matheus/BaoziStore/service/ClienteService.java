package drk.matheus.BaoziStore.service;

import drk.matheus.BaoziStore.dto.input.CreateClienteDTO;
import drk.matheus.BaoziStore.dto.input.CreateProdutoDTO;
import drk.matheus.BaoziStore.dto.output.ClienteResponseDTO;
import drk.matheus.BaoziStore.dto.output.ProdutoResponseDTO;
import drk.matheus.BaoziStore.entity.Cliente;
import drk.matheus.BaoziStore.mapper.ClienteMapper;
import drk.matheus.BaoziStore.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {
    private final ClienteRepository repository;
    private final ClienteMapper mapper;

    public ClienteService(ClienteRepository repository, ClienteMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public ClienteResponseDTO create(CreateClienteDTO dto) {
        Cliente p = mapper.toEntity(dto);
        Cliente salvo = repository.save(p);

        return mapper.toResponse(salvo);
    }

    public List<ClienteResponseDTO> listAll() {
        return repository.findAll().stream().map(mapper::toResponse).toList();
    }

    public ClienteResponseDTO listById(Long id) {
        var clienteEncontrado = repository.findById(id).orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        return mapper.toResponse(clienteEncontrado);
    }

    public void deleteById(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Cliente não encontrado");
        }

        repository.deleteById(id);
    }

    public ClienteResponseDTO updateById(Long id, CreateClienteDTO dto) {

        var clienteEncontrado = repository.findById(id).orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        clienteEncontrado.setNome(dto.nome());

        var salvo = repository.save(clienteEncontrado);
        return mapper.toResponse(salvo);
    }
}
