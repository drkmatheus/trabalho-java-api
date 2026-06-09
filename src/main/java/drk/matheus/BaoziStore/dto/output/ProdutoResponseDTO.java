package drk.matheus.BaoziStore.dto.output;

import java.math.BigDecimal;

public record ProdutoResponseDTO(Long id,String nome,
                                 BigDecimal preco,
                                 Boolean estoque) {
}
