package pl.coderslab.RentalOffice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.RentalOffice.entity.BorrowedEquipment;

import java.util.List;

public interface BorrowedEquipmentRepository extends JpaRepository<BorrowedEquipment, Long> {

    @Query(value = "SELECT * FROM borrowed_equipment WHERE id_contract=?1", nativeQuery = true)
    List<BorrowedEquipment> equipmentForContract(Long id);
}
