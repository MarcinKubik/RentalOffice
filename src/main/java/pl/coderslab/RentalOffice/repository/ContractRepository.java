package pl.coderslab.RentalOffice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.RentalOffice.entity.Contract;

public interface ContractRepository extends JpaRepository<Contract, Long> {
    public Contract findFirstByOrderByIdDesc();
}
