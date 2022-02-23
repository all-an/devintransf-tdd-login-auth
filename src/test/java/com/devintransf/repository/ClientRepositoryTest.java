package com.devintransf.repository;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.devintransf.entity.Cliente;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClientRepositoryTest {
	
	@Autowired
	ClientRepository repository;
	
	@Test
	public void testSave() {
		Cliente c = new Cliente();
		
		c.setCpf("8754665352");
		c.setName("Teste");
		c.setPassword("123456");
		c.setEmail("client@client.com");
		
		Cliente responseClient = repository.save(c);
		
		assertNotNull(responseClient);
	}

}
