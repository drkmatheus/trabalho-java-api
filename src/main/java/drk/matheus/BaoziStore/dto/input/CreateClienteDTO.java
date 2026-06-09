package drk.matheus.BaoziStore.dto.input;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record CreateClienteDTO(

        @NotBlank(message = "Nome é obrigatório")
        String nome,
        LocalDate clienteDesde
) {
}
