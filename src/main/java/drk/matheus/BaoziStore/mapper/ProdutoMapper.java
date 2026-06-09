package drk.matheus.BaoziStore.mapper;

import drk.matheus.BaoziStore.dto.input.CreateProdutoDTO;
import drk.matheus.BaoziStore.dto.output.ProdutoResponseDTO;
import drk.matheus.BaoziStore.entity.Produto;
import org.springframework.stereotype.Component;

@Component
public class ProdutoMapper {
    public Produto toEntity(CreateProdutoDTO dto) {
        Produto p = new Produto();
        p.setNome(dto.nome());
        p.setPreco(dto.preco());
        p.setEstoque(dto.estoque());

        return p;
    }

    public ProdutoResponseDTO toResponse(Produto p) {
        return new ProdutoResponseDTO(p.getId(),p.getNome(),p.getPreco(),p.getEstoque());
    }
}
