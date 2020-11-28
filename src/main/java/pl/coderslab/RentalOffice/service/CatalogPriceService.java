package pl.coderslab.RentalOffice.service;

import org.springframework.stereotype.Service;
import pl.coderslab.RentalOffice.entity.CatalogPrice;
import pl.coderslab.RentalOffice.repository.CatalogPriceRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CatalogPriceService {
    private final CatalogPriceRepository catalogPriceRepository;

    public CatalogPriceService(CatalogPriceRepository catalogPriceRepository) {
        this.catalogPriceRepository = catalogPriceRepository;
    }

    public List<CatalogPrice> catalogPriceList(){
        return catalogPriceRepository.findAll();
    }

    public Optional<CatalogPrice> get(Long id){
        Optional<CatalogPrice> optionalCatalogPrice = catalogPriceRepository.findById(id);
        return optionalCatalogPrice;
    }

    public void add(CatalogPrice catalogPrice){
        catalogPriceRepository.save(catalogPrice);
    }

    public void update(CatalogPrice catalogPrice){
        catalogPriceRepository.save(catalogPrice);
    }

    public void delete(Long id){
        catalogPriceRepository.deleteById(id);
    }
}
