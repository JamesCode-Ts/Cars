package br.com.automobiles.cars.service;

import br.com.automobiles.cars.model.Car;
import br.com.automobiles.cars.model.Sale;

public interface SaleService {

	
	Sale findById(Long id);

	Sale create(Sale saleToCreate);
	
	
	Sale update(Long id, Sale entity);
	  
	void delete(Long id);

}
