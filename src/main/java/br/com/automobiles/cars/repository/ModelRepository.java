package br.com.automobiles.cars.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import br.com.automobiles.cars.model.Model;

public interface ModelRepository extends JpaRepository<Model, Long> {

}
