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
		if(!clientDao.register(client)) {
			return false;
		}
		
		return true;

	}

	@Override
	public Client findById(Long id) throws Exception{
		Client client = clientDao.find(id);
		
		if(client == null) {
			return null;				
		}
			
		return client;
		
	}

	@Override
	public boolean delete(Long id) throws Exception{
			
			if(!clientDao.delete(id)) {
				return false;				
			}
				
			return true;
		
	}

	@Override
	public boolean update(Client c) throws Exception{
		if(!clientDao.update(c)) {
			return false;				
		}
			
		return true;
	}

}
