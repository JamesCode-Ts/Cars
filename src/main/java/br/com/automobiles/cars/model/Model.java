package br.com.automobiles.cars.model;

import jakarta.persistence.Entity;

@Entity
public class Model {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
