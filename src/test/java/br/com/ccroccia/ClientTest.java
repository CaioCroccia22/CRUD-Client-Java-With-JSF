package br.com.ccroccia;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import br.com.ccroccia.dao.ClientDAO;
import br.com.ccroccia.dao.IClientDao;
import br.com.ccroccia.domain.Client;


public class ClientTest {


	private IClientDao clientDAO;


	@Test
	public void saveTest() throws Exception {
		clientDAO = new ClientDAO();

		Client client = new Client();
		client.setCpf(121212121L);
		client.setName("Caio Croccia");
		client.setAge(25);
		client.setPhone(11999999999L);
		client.setAddress("Rua Teste");
		client.setNumber(100);
		client.setCity("São Paulo");
		client.setState("PD");
		Boolean registered = clientDAO.register(client);
		Assertions.assertTrue(registered);

		Client clientBD = clientDAO.find(121212121L);
		Assertions.assertNotNull(clientBD);
		Assertions.assertEquals(client.getCpf(), clientBD.getCpf());
		Assertions.assertEquals(client.getName(), clientBD.getName());

		Boolean deleted = clientDAO.delete(client.getCpf());
		Assertions.assertTrue(deleted);
	}

	@Test
	public void findTest() throws Exception {
		clientDAO = new ClientDAO();

		Client client = new Client();
		client.setCpf(323232323L);
		client.setName("Caio Croccia");
		client.setAge(25);
		client.setPhone(11999999999L);
		client.setAddress("Rua Teste");
		client.setNumber(200);
		client.setCity("São Paulo");
		client.setState("SR");
		Boolean registered = clientDAO.register(client);
		Assertions.assertTrue(registered);

		Client clientBD = clientDAO.find(323232323L);
		Assertions.assertNotNull(clientBD);
		Assertions.assertEquals(client.getCpf(), clientBD.getCpf());
		Assertions.assertEquals(client.getName(), clientBD.getName());

		Boolean deleted = clientDAO.delete(323232323L);
		Assertions.assertTrue(deleted);
	}

	@Test
	public void deleteTest() throws Exception {
		clientDAO = new ClientDAO();

		Client client = new Client();
		client.setCpf(36466545L);
		client.setName("Rodrigo Pires");
		client.setAge(30);
		// Here we can use @Beforeeach/@AfterEach but I prefer to change CPF value
		client.setPhone(11888888888L);
		client.setAddress("Rua Exemplo");
		client.setNumber(300);
		client.setCity("Rio de Janeiro");
		client.setState("PA");
		Boolean registered = clientDAO.register(client);
		Assertions.assertTrue(registered);

		Client clientBD = clientDAO.find(323232323L);
		Assertions.assertNotNull(clientBD);
		Assertions.assertEquals(client.getCpf(), clientBD.getCpf());
		Assertions.assertEquals(client.getName(), clientBD.getName());

		Boolean deleted = clientDAO.delete(323232323L);
		Assertions.assertTrue(deleted);
	}


	@Test
	public void updateTest() throws Exception {
		clientDAO = new ClientDAO();

		Client client = new Client();
		client.setCpf(786755765L);
		client.setName("Caio Croccia");
		client.setAge(25);
		client.setPhone(11999999999L);
		client.setAddress("Rua Teste");
		client.setNumber(400);
		client.setCity("São Paulo");
		client.setState("SA");
		Boolean registered = clientDAO.register(client);
		Assertions.assertTrue(registered);

		Client clientBD = clientDAO.find(786755765L);
		Assertions.assertNotNull(clientBD);
		Assertions.assertEquals(client.getCpf(), clientBD.getCpf());
		Assertions.assertEquals(client.getName(), clientBD.getName());
		
		
		// We should create change client class from DB to update on database
		clientBD.setName("Change Name");
		
		Boolean updated = clientDAO.update(clientBD);
		Assertions.assertTrue(updated);

		Boolean deleted = clientDAO.delete(786755765L);
		Assertions.assertTrue(deleted);
	}
}
