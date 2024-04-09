package br.com.automobiles.cars.service.impl;

import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import br.com.automobiles.cars.model.Car;
import br.com.automobiles.cars.repository.CarRepository;

import br.com.automobiles.cars.service.CarService;

@Service
public class CarServiceImpl implements CarService{

    private final CarRepository carRepository;

    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public Car findById(Long id) {
        return carRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Car create(Car carToCreate) {

      
        return carRepository.save(carToCreate);
    }
}