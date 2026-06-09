package drk.matheus.BaoziStore.mapper;

import drk.matheus.BaoziStore.dto.input.CreatePedidoDTO;
import drk.matheus.BaoziStore.dto.output.PedidoResponseDTO;
import drk.matheus.BaoziStore.entity.Pedido;
import org.springframework.stereotype.Component;

@Component
public class PedidoMapper {
    public Pedido toEntity(CreatePedidoDTO dto) {
        Pedido p = new Pedido();
        p.setClienteId(dto.clienteId());
        p.setProdutoId(dto.produtoId());
        p.setQuantidade(dto.quantidade());

        return p;
    }

    public PedidoResponseDTO toResponse(Pedido p) {
        return new PedidoResponseDTO(p.getId(),p.getClienteId(),p.getProdutoId(),p.getQuantidade());
    }
}
