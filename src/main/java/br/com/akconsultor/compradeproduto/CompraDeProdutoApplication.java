package br.com.akconsultor.compradeproduto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CompraDeProdutoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CompraDeProdutoApplication.class, args);
	}

}
