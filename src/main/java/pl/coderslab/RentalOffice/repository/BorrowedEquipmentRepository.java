package pl.coderslab.RentalOffice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.RentalOffice.entity.BorrowedEquipment;

import java.util.List;

public interface BorrowedEquipmentRepository extends JpaRepository<BorrowedEquipment, Long> {

    @Query(value = "SELECT * FROM borrowed_equipment WHERE id_contract=?1", nativeQuery = true)
    List<BorrowedEquipment> equipmentForContract(Long id);

    @Query(value = "SELECT * FROM borrowed_equipment WHERE equipment_id=?1",nativeQuery = true)
    List<BorrowedEquipment> findByEquipmentId(Long id);

    @Query("SELECT b FROM BorrowedEquipment b WHERE b.equipment.available=false ORDER BY b.borrowedTo DESC")
    List<BorrowedEquipment> findStillBorrowedEquipment();

    /*@Query("SELECT * FROM borrowed_equipment WHERE ", nativeQuery = true)
    List<BorrowedEquipment> findStillBorrowedEquipment();*/
}
