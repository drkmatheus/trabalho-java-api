package drk.matheus.BaoziStore.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "pedido")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn (name = "cliente_id", nullable = false)
    private Cliente cliente;

    @ManyToOne
    @JoinColumn (name = "produto_id", nullable = false)
    private Produto produto;
    @Column(nullable = false)
    private Integer quantidade;

    public Pedido() {
    }

    public Pedido(Long id, Cliente cliente, Produto produto, Integer quantidade) {
        this.id = id;
        this.cliente = cliente;
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
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
        return Objects.equals(id, pedido.id) && Objects.equals(cliente, pedido.cliente) && Objects.equals(produto, pedido.produto) && Objects.equals(quantidade, pedido.quantidade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cliente, produto, quantidade);
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", cliente=" + cliente +
                ", produto=" + produto +
                ", quantidade=" + quantidade +
                '}';
    }
}
