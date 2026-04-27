package br.com.ccroccia.service;


import br.com.ccroccia.domain.Client;

public interface IClientService {

	boolean save(Client client) throws Exception;

	Client findById(Long id) throws Exception;

	boolean delete(Long id) throws Exception;

	boolean update(Client client) throws Exception;


}
