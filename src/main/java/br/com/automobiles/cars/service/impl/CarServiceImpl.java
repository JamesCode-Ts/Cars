package br.com.automobiles.cars.service.impl;

import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;

import br.com.automobiles.cars.model.Car;
import br.com.automobiles.cars.model.Sale;
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
    
    

    public Car update(Long id, Car carToUpdate) {
       
        Car dbCar= this.findById(id);
        if (!dbCar.getId().equals(carToUpdate.getId())) {
            throw new IllegalArgumentException("Update IDs must be the same.");
        }

        dbCar.setPrice(carToUpdate.getPrice());
        dbCar.setYear(carToUpdate.getYear());
        dbCar.setCodeFipe(carToUpdate.getCodeFipe());
        dbCar.setModel(carToUpdate.getModel());
        dbCar.setBrand(carToUpdate.getBrand());

        return this.carRepository.save(dbCar);
    }

    public void delete(Long id) {
        
    	Car dbCar = this.findById(id);
        this.carRepository.delete(dbCar);
    }
    

}