package br.com.automobiles.cars.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.automobiles.cars.model.Brand;


public interface BrandRepository extends JpaRepository<Brand, Long> {

}
