package pl.coderslab.RentalOffice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.RentalOffice.entity.CatalogPrice;

public interface CatalogPriceRepository extends JpaRepository<CatalogPrice, Long> {
}
