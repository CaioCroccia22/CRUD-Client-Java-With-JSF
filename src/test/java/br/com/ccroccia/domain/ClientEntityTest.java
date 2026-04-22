package br.com.ccroccia.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import annotation.Column;
import annotation.KeyType;
import annotation.Table;


public class ClientEntityTest {

	@Test
	public void deveCriarClienteComTodosOsCampos() {
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
	public void classeClientDeveTerAnotacaoTable() {
		Table table = Client.class.getAnnotation(Table.class);
		Assertions.assertNotNull(table, "Client deve estar anotada com @Table");
		Assertions.assertEquals("Client", table.tableName());
	}

	@Test
	public void campoCpfDeveSerKeyType() throws Exception {
		java.lang.reflect.Field cpf = Client.class.getDeclaredField("cpf");
		KeyType key = cpf.getAnnotation(KeyType.class);
		Column col = cpf.getAnnotation(Column.class);
		Assertions.assertNotNull(key, "cpf deve estar anotado com @KeyType");
		Assertions.assertNotNull(col, "cpf deve estar anotado com @Column");
		Assertions.assertEquals("cd_cpf", col.columnName());
	}
}
