package com.devintransf.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devintransf.entity.Cliente;

public interface ClientRepository extends JpaRepository<Cliente, Long> {
	
	Optional<Cliente> findByEmailEquals(String email);

}
