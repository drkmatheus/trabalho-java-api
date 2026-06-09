package drk.matheus.BaoziStore.mapper;

import drk.matheus.BaoziStore.dto.input.CreateClienteDTO;
import drk.matheus.BaoziStore.dto.output.ClienteResponseDTO;
import drk.matheus.BaoziStore.entity.Cliente;
import org.springframework.stereotype.Component;

@Component
public class ClienteMapper {
    public Cliente toEntity(CreateClienteDTO dto) {
        Cliente c = new Cliente();
        c.setNome(dto.nome());

        return c;
    }

    public ClienteResponseDTO toResponse(Cliente c) {
        return new ClienteResponseDTO(c.getId(),c.getNome(),c.getClienteDesde());
    }
}
