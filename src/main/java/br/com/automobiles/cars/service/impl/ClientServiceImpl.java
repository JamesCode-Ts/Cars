package br.com.automobiles.cars.service.impl;

import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import br.com.automobiles.cars.model.Client;
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
}
