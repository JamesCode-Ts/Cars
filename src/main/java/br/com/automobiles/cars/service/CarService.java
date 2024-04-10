package br.com.automobiles.cars.service;

import br.com.automobiles.cars.model.Car;

public interface CarService {
	

	Car findById(Long id);

	Car create(Car carToCreate);
	
	Car update(Long id, Car entity);
	  
	void delete(Long id);

}
