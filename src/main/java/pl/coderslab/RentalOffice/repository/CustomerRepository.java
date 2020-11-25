package pl.coderslab.RentalOffice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.RentalOffice.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
