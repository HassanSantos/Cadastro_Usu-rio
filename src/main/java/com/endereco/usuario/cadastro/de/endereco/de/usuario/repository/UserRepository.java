package com.endereco.usuario.cadastro.de.endereco.de.usuario.repository;

import java.util.Optional;

import com.endereco.usuario.cadastro.de.endereco.de.usuario.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer>{
    Optional<User> findByCpf(String cpf);
    Optional<User> findByEmail(String email);
    // User findByidUser(int idUser);
}
