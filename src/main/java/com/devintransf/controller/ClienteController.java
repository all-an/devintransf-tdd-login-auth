package com.devintransf.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devintransf.entity.Cliente;
import com.devintransf.service.ClienteService;

@RestController
@RequestMapping("user")
public class ClienteController {

	@Autowired
	private ClienteService service;
	
	@PostMapping
	public ResponseEntity<Response<UserDTO>> create(@Valid @RequestBody UserDTO dto, BindingResult result){
		Response<UserDTO> response = new Response<UserDTO>();
		
		Cliente cliente = service.save(this.convertDtoToEntity(dto));
		
		response.se
		
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	private Cliente convertDtoToEntity(ClienteDTO dto) {
		Cliente c = new Cliente();
		c.setEmail(dto.getEmail());
		c.setName(dto.getName());
		c.setPassword(dto.getPassword());
		
		return c;
	}
	
	private ClienteDTO convertEntityToDto(Cliente c) {
		ClienteDTO dto = new ClienteDTO();
		dto.setEmail(c.getEmail());
		dto.setName(c.getName());
		dto.setPassword(c.getPassword());

		return dto;
	}
	
}
