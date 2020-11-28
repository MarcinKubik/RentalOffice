package pl.coderslab.RentalOffice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.RentalOffice.entity.Equipment;

import java.util.List;

public interface EquipmentRepository extends JpaRepository<Equipment, Long> {
    public Equipment findFirstByOrderByIdDesc();

    @Query("SELECT e FROM Equipment e where e.available=false")
    public List<Equipment> findAllBorrowed();

    @Query("SELECT e FROM Equipment e where e.available=true")
    public List<Equipment> findAllAvailable();
}
