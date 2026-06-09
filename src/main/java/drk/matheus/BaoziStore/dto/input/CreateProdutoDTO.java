package drk.matheus.BaoziStore.dto.input;

import java.math.BigDecimal;

public record CreateProdutoDTO(String nome,
        BigDecimal preco,
        Boolean estoque) {
}
