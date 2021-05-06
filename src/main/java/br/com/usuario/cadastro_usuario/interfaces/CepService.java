package br.com.usuario.cadastro_usuario.interfaces;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.usuario.cadastro_usuario.dto.EnderecoDto;
@FeignClient(url= "https://viacep.com.br/ws/" , name = "viacep")
public interface CepService {
    @GetMapping("{cep}/json")
    EnderecoDto buscaEnderecoPorCep(@PathVariable("cep") String cep);
}
