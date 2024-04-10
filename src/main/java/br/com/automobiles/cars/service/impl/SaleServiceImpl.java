package br.com.automobiles.cars.service.impl;

import java.util.NoSuchElementException;
import org.springframework.stereotype.Service;

import br.com.automobiles.cars.model.Car;
import br.com.automobiles.cars.model.Client;
import br.com.automobiles.cars.model.Sale;
import br.com.automobiles.cars.repository.SaleRepository;
import br.com.automobiles.cars.service.SaleService;

@Service
public class SaleServiceImpl implements SaleService{
	

    private final SaleRepository saleRepository;

    public SaleServiceImpl(SaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }

    @Override
    public Sale findById(Long id) {
        return saleRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Sale create(Sale saleToCreate) {
      
        return saleRepository.save(saleToCreate);
    }
    
    public Sale update(Long id, Sale saleToCreate) {
        
    	Sale dbSale= this.findById(id);
        if (!dbSale.getId().equals(saleToCreate.getId())) {
            throw new IllegalArgumentException("Update IDs must be the same.");
        }

        dbSale.setSaleDate(saleToCreate.getSaleDate());
        dbSale.setSaleHour(saleToCreate.getSaleHour());
        dbSale.setClient(saleToCreate.getClient());
     
        return this.saleRepository.save(dbSale);
    }

    public void delete(Long id) {
        
    	Sale dbSale = this.findById(id);
        this.saleRepository.delete(dbSale);
    }
    


}
