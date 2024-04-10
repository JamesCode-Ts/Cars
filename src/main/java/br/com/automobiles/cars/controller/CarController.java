package br.com.automobiles.cars.controller;

import java.net.URI;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import br.com.automobiles.cars.model.Car;
import br.com.automobiles.cars.service.CarService;

@RestController
@RequestMapping("/cars")
public class CarController {

	
	    private final CarService carService;

	    public CarController(CarService carService) {
	        this.carService = carService;
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<Car> findById(@PathVariable Long id) {
	       var car = carService.findById(id);
	       return ResponseEntity.ok(car);
	    }

	    @PostMapping
	    public ResponseEntity<Car> create(@RequestBody Car carToCreate) {
	        var carCreated = carService.create(carToCreate);
	        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
	                .path("/{id}")
	                .buildAndExpand(carCreated.getId())
	                .toUri();
	        return ResponseEntity.created(location).body(carCreated);
	    }
	    
	    @PutMapping("/{id}")
	    public ResponseEntity<Car> update(@PathVariable Long id, @RequestBody Car carToUpdate) {
	        var car = carService.update(id,carToUpdate);
	        return ResponseEntity.ok(car);
	    }
	    
	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> delete(@PathVariable Long id) {
	    	carService.delete(id);
	        return ResponseEntity.noContent().build();
	    }
	}

