package drk.matheus.BaoziStore.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "pedido")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private Long clienteId;
    @Column(nullable = false)
    private Long produtoId;
    @Column(nullable = false)
    private Integer quantidade;

    public Pedido() {
    }

    public Pedido(Long id, Long clienteId, Long produtoId, Integer quantidade) {
        this.id = id;
        this.clienteId = clienteId;
        this.produtoId = produtoId;
        this.quantidade = quantidade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public Long getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(Long produtoId) {
        this.produtoId = produtoId;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Pedido pedido = (Pedido) o;
        return Objects.equals(id, pedido.id) && Objects.equals(clienteId, pedido.clienteId) && Objects.equals(produtoId, pedido.produtoId) && Objects.equals(quantidade, pedido.quantidade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, clienteId, produtoId, quantidade);
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", clienteId=" + clienteId +
                ", produtoId=" + produtoId +
                ", quantidade=" + quantidade +
                '}';
    }
}
