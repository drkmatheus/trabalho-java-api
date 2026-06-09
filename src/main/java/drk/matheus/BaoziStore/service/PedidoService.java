package drk.matheus.BaoziStore.service;

import drk.matheus.BaoziStore.dto.input.CreatePedidoDTO;
import drk.matheus.BaoziStore.dto.output.PedidoResponseDTO;
import drk.matheus.BaoziStore.entity.Pedido;
import drk.matheus.BaoziStore.mapper.PedidoMapper;
import drk.matheus.BaoziStore.repository.PedidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {
    private final PedidoRepository repository;
    private final PedidoMapper mapper;

    public PedidoService(PedidoRepository repository, PedidoMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public PedidoResponseDTO create(CreatePedidoDTO dto) {
        Pedido p = mapper.toEntity(dto);
        Pedido salvo = repository.save(p);

        return mapper.toResponse(salvo);
    }

    public List<PedidoResponseDTO> listAll() {
        return repository.findAll().stream().map(mapper::toResponse).toList();
    }
}
