package pl.coderslab.RentalOffice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.RentalOffice.entity.BorrowedEquipment;

public interface BorrowedEquipmentRepository extends JpaRepository<BorrowedEquipment, Long> {
}
