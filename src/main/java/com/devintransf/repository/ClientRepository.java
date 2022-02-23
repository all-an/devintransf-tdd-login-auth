package com.devintransf.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devintransf.entity.Cliente;

public interface ClientRepository extends JpaRepository<Cliente, Long> {

}
