package pl.coderslab.RentalOffice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.RentalOffice.entity.CopyOfContract;

public interface CopyOfContractRepository extends JpaRepository<CopyOfContract, Long> {
}
