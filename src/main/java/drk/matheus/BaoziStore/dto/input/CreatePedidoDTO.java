package drk.matheus.BaoziStore.dto.input;

import java.math.BigDecimal;

public record CreatePedidoDTO(Long clienteId
        , Long produtoId
        , Integer quantidade) {
}
