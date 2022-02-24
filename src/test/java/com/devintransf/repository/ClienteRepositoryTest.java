package com.devintransf.repository;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Optional;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.devintransf.entity.Cliente;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClienteRepositoryTest {
	
	private static final String EMAIL = "email@teste.com";
	
	@Autowired
	ClienteRepository repository;
	
	@Before
	public void setUp() {
		Cliente c = new Cliente();
		c.setCpf("09930093796");
		c.setName("Set up Cliente");
		c.setPassword("123456");
		c.setEmail(EMAIL);
		
		repository.save(c);
		
	}
	
	@After
	public void tearDown() {
		
	}
	
	@Test
	public void testSave() {
		Cliente c = new Cliente();
		
		c.setCpf("09930093796");
		c.setName("Teste");
		c.setPassword("123456");
		c.setEmail("client@client.com");
		
		Cliente responseClient = repository.save(c);
		
		assertNotNull(responseClient);
	}
	
	@Test
	public void testFindByEmail() {
		Optional<Cliente> response = repository.findByEmailEquals(EMAIL);
	
		assertTrue(response.isPresent());
		assertEquals(response.get().getEmail(), EMAIL);
	}

}
