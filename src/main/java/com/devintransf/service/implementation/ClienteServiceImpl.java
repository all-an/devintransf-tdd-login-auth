package com.devintransf.service.implementation;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devintransf.entity.Cliente;
import com.devintransf.repository.ClienteRepository;
import com.devintransf.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService{

	@Autowired
	ClienteRepository repository;
	
	@Override
	public Cliente save(Cliente cliente) {
		return repository.save(cliente);
	}

	@Override
	public Optional<Cliente> findByEmail(String email) {
		return repository.findByEmailEquals(email);
	}

}
