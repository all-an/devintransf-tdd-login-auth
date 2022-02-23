package com.devintransf.repository;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
public class ClientRepositoryTest {
	
	@Autowired
	ClientRepository repository;
	
	@Teste
	public void testSave() {
		Client c = new Client();
		c.setCpf("868686868686");
		c.setName("Teste");
		c.setPassword("123456");
		c.setEmail("client@client.com");
		
		Client responseClient = repository.save(c);
		
		assertNotNull(responseClient);
	}

}
