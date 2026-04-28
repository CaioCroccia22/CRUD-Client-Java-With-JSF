package br.com.ccroccia.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import br.com.ccroccia.annotation.Column;
import br.com.ccroccia.annotation.KeyType;
import br.com.ccroccia.annotation.Table;


public class ClientEntityTest {

	@Test
	public void createClientWithAllFields() {
		Client client = new Client();
		client.setCpf(12345678901L);
		client.setName("Caio Croccia");
		client.setPhone(11999999999L);
		client.setAddress("Rua Teste");
		client.setNumber(100);
		client.setCity("São Paulo");
		client.setState("SP");
		client.setAge(25);

		Assertions.assertEquals(12345678901L, client.getCpf());
		Assertions.assertEquals("Caio Croccia", client.getName());
		Assertions.assertEquals(25, client.getAge());
		Assertions.assertEquals(11999999999L, client.getPhone());
		Assertions.assertEquals("Rua Teste", client.getAddress());
		Assertions.assertEquals(100, client.getNumber());
		Assertions.assertEquals("São Paulo", client.getCity());
		Assertions.assertEquals("SP", client.getState());
	}

	@Test
	public void validateClassClientWithAnnotation() {
		Table table = Client.class.getAnnotation(Table.class);
		Assertions.assertNotNull(table, "Client deve estar anotada com @Table");
		Assertions.assertEquals("Client", table.tableName());
	}

	@Test
	public void KeyType() throws Exception {
		java.lang.reflect.Field id = Client.class.getDeclaredField("id");
		KeyType key = id .getAnnotation(KeyType.class);
		Column col = id .getAnnotation(Column.class);
		Assertions.assertNotNull(key, "o id deve estar anotado com @KeyType");
		Assertions.assertNotNull(col, "o id deve estar anotado com @Column");
		Assertions.assertEquals("cd_client", col.columnName());
	}
}
