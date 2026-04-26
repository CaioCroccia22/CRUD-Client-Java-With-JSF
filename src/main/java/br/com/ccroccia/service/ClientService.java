package br.com.ccroccia.service;

import br.com.ccroccia.dao.IClientDao;
import br.com.ccroccia.dao.Persistent;
import br.com.ccroccia.domain.Client;
import br.com.ccroccia.exceptions.KeyTypeNotFoundException;

public class ClientService implements IClientService {

	private IClientDao clientDao;


	public ClientService(IClientDao clientDao) {
		this.clientDao = clientDao;
	}

	@Override
	public boolean save(Client client) throws Exception {
		clientDao.register(client);
		return true;

	}

	@Override
	public Client findById(Long id) {
		try {
			Client client = clientDao.find(id);
			return client;
		} catch(Exception e) {
				System.out.println("Erro ao localizar cliente");
		}
		return null;
	}

	@Override
	public void delete(Long id) {
		try {
			clientDao.delete(id);
		} catch(Exception e) {
				System.out.println("Erro ao excluir cliente");
		}
		
	}

	@Override
	public void update(Client c) {
		try {
			clientDao.update(c);			
		} catch(Exception e) {
			System.out.println("Erro ao atualizar cliente");
		}
	}

}
