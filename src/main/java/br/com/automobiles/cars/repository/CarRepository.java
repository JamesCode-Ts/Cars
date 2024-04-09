package br.com.automobiles.cars.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.automobiles.cars.model.Car;


public interface CarRepository extends JpaRepository<Car, Long> {

}
