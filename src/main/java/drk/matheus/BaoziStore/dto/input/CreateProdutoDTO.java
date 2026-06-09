package drk.matheus.BaoziStore.dto.input;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record CreateProdutoDTO(
        @NotBlank(message = "Nome é obrigatório")
        String nome,

        @NotNull(message = "Preço é obrigatório")
        @Min(value = 1, message = "Preço deve ser maior do que 0")
        BigDecimal preco,

        @NotNull(message = "A disponibilidade deve ser informada")
        Boolean estoque) {
}
