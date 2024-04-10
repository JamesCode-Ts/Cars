package br.com.automobiles.cars.service;


import br.com.automobiles.cars.model.Client;


public interface ClientService {
	
	Client findById(Long id);

	Client create(Client clientToCreate);

}
