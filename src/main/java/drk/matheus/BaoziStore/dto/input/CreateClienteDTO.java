package drk.matheus.BaoziStore.dto.input;

import java.time.LocalDate;

public record CreateClienteDTO(String nome, LocalDate clienteDesde) {
}
