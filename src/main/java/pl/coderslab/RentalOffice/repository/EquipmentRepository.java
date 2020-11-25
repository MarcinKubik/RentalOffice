package pl.coderslab.RentalOffice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.RentalOffice.entity.Equipment;

public interface EquipmentRepository extends JpaRepository<Equipment, Long> {
}
