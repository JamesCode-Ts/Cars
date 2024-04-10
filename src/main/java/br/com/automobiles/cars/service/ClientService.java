package br.com.automobiles.cars.service;


import br.com.automobiles.cars.model.Car;
import br.com.automobiles.cars.model.Client;


public interface ClientService {
	
	Client findById(Long id);

	Client create(Client clientToCreate);
	
	Client update(Long id, Client entity);
	  
	void delete(Long id);

}
