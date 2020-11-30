package pl.coderslab.RentalOffice.service;

import org.springframework.stereotype.Service;
import pl.coderslab.RentalOffice.entity.BorrowedEquipment;
import pl.coderslab.RentalOffice.repository.BorrowedEquipmentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BorrowedEquipmentService {

    private final BorrowedEquipmentRepository borrowedEquipmentRepository;

    public BorrowedEquipmentService(BorrowedEquipmentRepository borrowedEquipmentRepository) {
        this.borrowedEquipmentRepository = borrowedEquipmentRepository;
    }

    public List<BorrowedEquipment> borrowedEquipmentList(){
        return borrowedEquipmentRepository.findAll();
    }

    public List<BorrowedEquipment> equipmentForContract(Long id){
        return borrowedEquipmentRepository.equipmentForContract(id);
    }

    public List<BorrowedEquipment> findByEquipmentId(Long id){
        return borrowedEquipmentRepository.findByEquipmentId(id);
    }

    public Optional<BorrowedEquipment> get(Long id){
        Optional<BorrowedEquipment> optionalBorrowedEquipment = borrowedEquipmentRepository.findById(id);
        return  optionalBorrowedEquipment;
    }

    public void add(BorrowedEquipment borrowedEquipment){
        borrowedEquipmentRepository.save(borrowedEquipment);
    }

    public void update(BorrowedEquipment borrowedEquipment){
        borrowedEquipmentRepository.save(borrowedEquipment);
    }

    public void delete(Long id){
        borrowedEquipmentRepository.deleteById(id);
    }
}
