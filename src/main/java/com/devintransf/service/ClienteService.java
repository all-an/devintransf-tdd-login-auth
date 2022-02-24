package com.devintransf.service;

import java.util.Optional;

import com.devintransf.entity.Cliente;

public interface ClienteService {
	
	Cliente save(Cliente cliente);

	Optional<Cliente> findByEmail(String email);
}
