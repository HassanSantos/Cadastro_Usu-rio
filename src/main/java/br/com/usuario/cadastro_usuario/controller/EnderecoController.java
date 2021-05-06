package br.com.usuario.cadastro_usuario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.usuario.cadastro_usuario.dto.EnderecoDto;
import br.com.usuario.cadastro_usuario.interfaces.CepService;

@RestController
public class EnderecoController {
    @Autowired
	private CepService cepService;

    @PostMapping("")
    public ResponseEntity<EnderecoDto> getCep(@RequestBody EnderecoDto endereco) {
        var cep = endereco.getCep();
        endereco =  cepService.buscaEnderecoPorCep(cep);
        return endereco != null ? ResponseEntity.ok().body(endereco) : ResponseEntity.notFound().build();
    }
}
