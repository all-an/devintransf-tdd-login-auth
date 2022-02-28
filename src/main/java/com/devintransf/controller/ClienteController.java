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

import com.devintransf.dto.ClienteDTO;
import com.devintransf.entity.Cliente;
import com.devintransf.response.Response;
import com.devintransf.service.ClienteService;
import com.devintransf.util.Bcrypt;

@RestController
@RequestMapping("clientes")
public class ClienteController {

	@Autowired
	private ClienteService service;
	
	@PostMapping
	public ResponseEntity<Response<ClienteDTO>> create(@Valid @RequestBody ClienteDTO dto, BindingResult result){
		Response<ClienteDTO> response = new Response<ClienteDTO>();
		
		if(result.hasErrors()) {
			result.getAllErrors().forEach(e -> response.getErrors().add(e.getDefaultMessage()));
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}
		
		Cliente cliente = service.save(this.convertDtoToEntity(dto));
		
		response.setData(this.convertEntityToDto(cliente));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	private Cliente convertDtoToEntity(ClienteDTO dto) {
		Cliente c = new Cliente();
		c.setId(dto.getId());
		c.setCpf(dto.getCpf());
		c.setEmail(dto.getEmail());
		c.setName(dto.getName());
		c.setPassword(Bcrypt.getHashPassword(dto.getPassword()));
		
		return c;
	}
	
	private ClienteDTO convertEntityToDto(Cliente c) {
		ClienteDTO dto = new ClienteDTO();
		dto.setId(c.getId());
		dto.setCpf(c.getCpf());
		dto.setEmail(c.getEmail()); 
		dto.setName(c.getName());

		return dto;
	}
	
}
