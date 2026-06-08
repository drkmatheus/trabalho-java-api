package drk.matheus.BaoziStore;

import drk.matheus.BaoziStore.entity.Cliente;
import drk.matheus.BaoziStore.entity.Pedido;
import drk.matheus.BaoziStore.entity.Produto;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootApplication
@RestController
public class BaoziStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BaoziStoreApplication.class, args);
	}

	@GetMapping("/")
	public String status() {

		var cliente1 = new Cliente();
		cliente1.setId(1L);
		cliente1.setNome("Teste");
		cliente1.setClienteDesde(LocalDate.now());

		var produto1 = new Produto();
		produto1.setId(1L);
		produto1.setNome("Pão");
		produto1.setPreco(BigDecimal.valueOf(2.99));
		produto1.setEstoque(true);

		var pedido1 = new Pedido();
		pedido1.setId(1L);
		pedido1.setProdutoId(1L);
		pedido1.setClienteId(1L);
		pedido1.setQuantidade(2);

		return String.format("Cliente ==> %s, Produto ==> %s, Pedido ==> %s",cliente1.toString(), produto1.toString(), pedido1.toString()); }

}
