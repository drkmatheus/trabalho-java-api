package drk.matheus.BaoziStore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class BaoziStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BaoziStoreApplication.class, args);
	}

	@GetMapping("/")
	public String status() { return "UP!"; }

}
