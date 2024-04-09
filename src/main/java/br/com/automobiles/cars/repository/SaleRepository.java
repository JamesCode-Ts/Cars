package br.com.automobiles.cars.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import br.com.automobiles.cars.model.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long> {

}
