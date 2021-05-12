package com.endereco.usuario.cadastro.de.endereco.de.usuario;

import com.endereco.usuario.cadastro.de.endereco.de.usuario.config.ModelMapperFactory;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients
public class CadastroDeEnderecoDeUsuarioApplication {

	public static void main(String[] args) {
		SpringApplication.run(CadastroDeEnderecoDeUsuarioApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapperFactory().getModelMapper();
	}

}
