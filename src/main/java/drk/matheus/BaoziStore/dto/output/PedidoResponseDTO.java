package drk.matheus.BaoziStore.dto.output;

import java.math.BigDecimal;

public record PedidoResponseDTO(Long id, Long clienteId, Long produtoId, Integer quantidade) {
}
