package drk.matheus.BaoziStore.dto.input;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record CreateClienteDTO(

        @NotBlank(message = "Nome é obrigatório")
        @Size(min = 2, max = 60)
        String nome
) {
}
