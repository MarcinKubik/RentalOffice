package pl.coderslab.RentalOffice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.RentalOffice.entity.Contract;

import java.util.List;

public interface ContractRepository extends JpaRepository<Contract, Long> {
     Contract findFirstByOrderByIdDesc();
     @Query(value = "SELECT * FROM contracts WHERE customer_id=?1", nativeQuery = true)
     List<Contract> findContractsOfCustomer(Long id);

     List<Contract> findByCustomerId(Long id);
     @Query(value = "SELECT * FROM contracts WHERE employee_id=?1", nativeQuery = true)
     List<Contract> findContractsOfEmployee(Long id);
}
