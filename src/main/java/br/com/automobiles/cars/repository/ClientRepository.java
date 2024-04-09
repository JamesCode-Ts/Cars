package br.com.automobiles.cars.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.automobiles.cars.model.Client;


public interface ClientRepository extends JpaRepository<Client, Long> {

}
