package br.com.ccroccia.service;

import br.com.ccroccia.dao.IClientDao;
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
	public Client findByCPF(Long cpf) {
		try {
			Client client = clientDao.find(cpf);
			return client;
		} catch(Exception e) {
				System.out.println("Erro ao localizar cliente");
		}
		return null;
	}

	@Override
	public void delete(Long cpf) {
		try {
			clientDao.delete(cpf);
		} catch(Exception e) {
				System.out.println("Erro ao excluir cliente");
		}
		
	}

	@Override
	public void update(Long cpf) {
		try {
			clientDao.update(cpf);			
		} catch(Exception e) {
			System.out.println("Erro ao atualizar cliente");
		}
	}

}
