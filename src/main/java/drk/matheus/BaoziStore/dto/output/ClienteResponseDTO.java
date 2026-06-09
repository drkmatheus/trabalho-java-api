package drk.matheus.BaoziStore.dto.output;

import java.time.LocalDate;

public record ClienteResponseDTO(Long id, String nome, LocalDate clienteDesde) {
}
