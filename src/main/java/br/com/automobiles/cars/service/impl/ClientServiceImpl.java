package br.com.automobiles.cars.service.impl;

import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import br.com.automobiles.cars.model.Client;
import br.com.automobiles.cars.model.Sale;
import br.com.automobiles.cars.repository.ClientRepository;
import br.com.automobiles.cars.service.ClientService;

@Service
public class ClientServiceImpl implements ClientService{

	
    private final ClientRepository clientRepository;

    public  ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public Client findById(Long id) {
        return clientRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Client create(Client clientToCreate) {
      
        return clientRepository.save(clientToCreate);
    }
    
   public Client update(Long id, Client clientToCreate) {
        
	   Client dbClient= this.findById(id);
        if (!dbClient.getId().equals(clientToCreate.getId())) {
            throw new IllegalArgumentException("Update IDs must be the same.");
        }

        dbClient.setName(clientToCreate.getName());
        dbClient.setCpf(clientToCreate.getCpf());
        dbClient.setAddress(clientToCreate.getAddress());
        dbClient.setTelefone(clientToCreate.getTelefone());
     
        return this.clientRepository.save(dbClient);
    }
   

   public void delete(Long id) {
     
	   Client dbClient = this.findById(id);
       this.clientRepository.delete(dbClient);
   }
   

}
