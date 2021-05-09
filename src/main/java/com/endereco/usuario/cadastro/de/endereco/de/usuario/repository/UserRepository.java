package com.endereco.usuario.cadastro.de.endereco.de.usuario.repository;

import java.util.List;

import com.endereco.usuario.cadastro.de.endereco.de.usuario.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer>{
    List<User> findByNome(String nome);
}
