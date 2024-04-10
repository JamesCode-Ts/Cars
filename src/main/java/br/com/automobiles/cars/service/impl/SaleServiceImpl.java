package br.com.automobiles.cars.service.impl;

import java.util.NoSuchElementException;
import org.springframework.stereotype.Service;
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

}
