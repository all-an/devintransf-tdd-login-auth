package com.devintransf.service;

import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.devintransf.entity.Cliente;
import com.devintransf.repository.ClienteRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class ClienteServiceTest {

	@MockBean
	ClienteRepository repository;
	
	@Autowired
	ClienteService service;
	
	@Before
	public void setUp() {
		BDDMockito.given(repository.findByEmailEquals(Mockito.anyString())).
		willReturn(Optional.of(new Cliente()));
	}
	
	@Test
	public void testFindByEmail() {
		Optional<Cliente> cliente = service.findByEmail("email@test.com");
		
		assertTrue(cliente.isPresent());
	}
}
