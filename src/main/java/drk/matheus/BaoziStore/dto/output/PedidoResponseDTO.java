package drk.matheus.BaoziStore.dto.output;

public record PedidoResponseDTO(Long id, ClienteResponseDTO cliente, ProdutoResponseDTO produto, Integer quantidade) {
}
