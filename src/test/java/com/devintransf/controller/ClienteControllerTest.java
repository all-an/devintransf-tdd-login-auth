package com.devintransf.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.devintransf.dto.ClienteDTO;
import com.devintransf.entity.Cliente;
import com.devintransf.service.ClienteService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class ClienteControllerTest {
	
	private static final String EMAIL = "email@teste.com";
	private static final String NAME = "Cliente Test";
	private static final String PASSWORD = "123456";
	private static final String CPF = "09930093796";
	
	private static final String URL = "/user";
	
	@MockBean
	ClienteService service;
	
	@Autowired
	MockMvc mvc;
	
	@Test
	public void testSave() throws Exception {
		
		BDDMockito.given(service.save(Mockito.any(Cliente.class))).willReturn(getMockUser());
		
		mvc.perform(MockMvcRequestBuilders.post(URL).content(getJsonPayLoad()) //performando um post mockado para testar o retorno status
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isCreated());
	}

	public Cliente getMockUser() {
		Cliente cliente = new Cliente();
		cliente.setEmail(EMAIL);
		cliente.setCpf(CPF);
		cliente.setName(NAME);
		cliente.setPassword(PASSWORD);
		
		return cliente;
	}
	
	public String getJsonPayLoad() throws JsonProcessingException {
		ClienteDTO dto = new ClienteDTO();
		
		dto.setEmail(EMAIL);
		dto.setName(NAME);
		dto.setPassword(PASSWORD);
		
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(dto);
	}
}
