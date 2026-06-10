package drk.matheus.BaoziStore.mapper;

import drk.matheus.BaoziStore.dto.input.CreatePedidoDTO;
import drk.matheus.BaoziStore.dto.output.PedidoResponseDTO;
import drk.matheus.BaoziStore.entity.Cliente;
import drk.matheus.BaoziStore.entity.Pedido;
import drk.matheus.BaoziStore.entity.Produto;
import org.springframework.stereotype.Component;

@Component
public class PedidoMapper {

    private final ClienteMapper clienteMapper;
    private final ProdutoMapper produtoMapper;

    public PedidoMapper(ClienteMapper clienteMapper, ProdutoMapper produtoMapper) {
        this.clienteMapper = clienteMapper;
        this.produtoMapper = produtoMapper;
    }

    public Pedido toEntity(Cliente cliente, Produto produto, CreatePedidoDTO dto) {
        Pedido p = new Pedido();
        p.setCliente(cliente);
        p.setProduto(produto);
        p.setQuantidade(dto.quantidade());

        return p;
    }

    public PedidoResponseDTO toResponse(Pedido p) {
        return new PedidoResponseDTO(p.getId(),clienteMapper.toResponse(p.getCliente()),produtoMapper.toResponse(p.getProduto()),p.getQuantidade());
    }
}
