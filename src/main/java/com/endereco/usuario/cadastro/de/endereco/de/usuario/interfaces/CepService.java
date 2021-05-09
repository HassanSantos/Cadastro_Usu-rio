package com.endereco.usuario.cadastro.de.endereco.de.usuario.interfaces;


import com.endereco.usuario.cadastro.de.endereco.de.usuario.model.Endereco;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@FeignClient(url= "https://viacep.com.br/ws/" , name = "viacep")
public interface CepService {
    @GetMapping("{cep}/json")
    Endereco buscaEnderecoPorCep(@PathVariable("cep") String cep);
}