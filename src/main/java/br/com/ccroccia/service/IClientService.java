package br.com.ccroccia.service;

import br.com.ccroccia.dao.Persistent;
import br.com.ccroccia.domain.Client;

public interface IClientService {

	boolean save(Client client) throws Exception;

	Client findById(Long id);

	void delete(Long id);

	void update(Client client);


}
