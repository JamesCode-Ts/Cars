package br.com.automobiles.cars.controller;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import br.com.automobiles.cars.model.Client;
import br.com.automobiles.cars.model.Sale;
import br.com.automobiles.cars.service.ClientService;

@RestController
@RequestMapping("/clients")
public class ClientController {

	
	    private final ClientService clientService;

	    public ClientController(ClientService clientService) {
	        this.clientService = clientService;
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<Client> findById(@PathVariable Long id) {
	       var client = clientService.findById(id);
	       return ResponseEntity.ok(client);
	    }

	    @PostMapping
	    public ResponseEntity<Client> create(@RequestBody Client clientToCreate) {
	        var clientCreated = clientService.create(clientToCreate);
	        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
	                .path("/{id}")
	                .buildAndExpand(clientCreated.getId())
	                .toUri();
	        return ResponseEntity.created(location).body(clientCreated);
	    }
	    
	    @PutMapping("/{id}")
	    public ResponseEntity<Client> update(@PathVariable Long id, @RequestBody Client clientToUpdate) {
	        var client = clientService.update(id,clientToUpdate);
	        return ResponseEntity.ok(client);
	    }
	    
	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> delete(@PathVariable Long id) {
	    	clientService.delete(id);
	        return ResponseEntity.noContent().build();
	    }
	}





