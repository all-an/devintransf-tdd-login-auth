package com.devintransf.repository;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
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
	
	private final String EMAIL = "email@teste.com";
	
	@Autowired
	ClienteRepository repository;
	
	@Before
	public void setUp() {
		Cliente c1 = new Cliente();
		c1.setCpf("09930093796");
		c1.setName("Set up Cliente");
		c1.setPassword("123456");
		c1.setEmail(EMAIL);
		
		repository.save(c1);
		System.out.println("SETUP Executado");
		
	}
	
	@After
	public void tearDown() {
		System.out.println("TEAR DOWN Executado");
		
	}

	
	
	@Test
	public void testSave() {
		Cliente c = new Cliente();
		c.setCpf("09930093796");
		c.setName("Set up Cliente");
		c.setPassword("123456");
		c.setEmail("test@testsave.com");
		
		Cliente responseClient = repository.save(c);
		
		assertNotNull(responseClient);
		System.out.println("SAVE TEST Executado");
	}
	
	@Test
	public void testFindByEmail() {
		repository.deleteById(3L);
		List<Cliente> lista = repository.findAll();
		for(Cliente c : lista) {
			System.out.println(c.toString());
		}
		System.out.println(repository.count());
		System.out.println("TENTANDO testar findByEmail");
		Optional<Cliente> response = repository.findByEmailEquals(EMAIL);
		
		assertTrue(response.isPresent());
		assertEquals(response.get().getEmail(), EMAIL);
	}

}
