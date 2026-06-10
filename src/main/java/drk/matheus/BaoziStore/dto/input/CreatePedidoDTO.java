package drk.matheus.BaoziStore.dto.input;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record CreatePedidoDTO(

        @NotNull(message = "O ID do cliente deve ser informado")
        @Positive(message = "O ID do cliente deve ser maior do que 0")
        Long clienteId,

        @NotNull(message = "O ID do produto deve ser informado")
        @Positive(message = "O ID do produto deve ser maior do que 0")
        Long produtoId,

        @NotNull(message = "A quantidade do produto deve ser informada")
        @Min(value = 1, message = "A quantidade do produto deve ser maior do que 0")
        Integer quantidade
) {
}
