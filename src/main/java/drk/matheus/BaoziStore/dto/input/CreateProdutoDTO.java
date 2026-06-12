package drk.matheus.BaoziStore.dto.input;

import java.math.BigDecimal;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateProdutoDTO(
        @NotBlank(message = "Nome é obrigatório")
        String nome,

        @NotNull(message = "Preço é obrigatório")
        @DecimalMin("0.01")
        BigDecimal preco,

        @NotNull(message = "A disponibilidade deve ser informada")
        Boolean estoque) {
}
