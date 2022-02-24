package com.devintransf.controller;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.devintransf.entity.Cliente;
import com.devintransf.service.ClienteService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class ClienteControllerTest {
	
	private static final String EMAIL = "email@teste.com";
	private static final String NAME = "Cliente Test";
	private static final String PASSWORD = "123456";
	private static final String CPF = "09930093796";
	
	
	@MockBean
	ClienteService service;
	
	@Autowired
	MockMvc mvc;
	
	public void testSave() {
		
	}

	public Cliente getMockUser() {
		Cliente cliente = new Cliente();
		cliente.setEmail(EMAIL);
		cliente.setCpf(CPF);
		cliente.setName(NAME);
		cliente.setPassword(PASSWORD);
		
		return cliente;
	}
	
	public String getJsonPayLoad() {
		ClienteDTO dto = new ClienteDTO();
	}
}
