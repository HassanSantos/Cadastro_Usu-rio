package com.endereco.usuario.cadastro.de.endereco.de.usuario;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CadastroDeEnderecoDeUsuarioApplication {

	public static void main(String[] args) {
		SpringApplication.run(CadastroDeEnderecoDeUsuarioApplication.class, args);
	}

}
