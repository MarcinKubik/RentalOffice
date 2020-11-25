package pl.coderslab.RentalOffice.service;

import org.springframework.stereotype.Service;
import pl.coderslab.RentalOffice.entity.Equipment;
import pl.coderslab.RentalOffice.repository.EquipmentRepository;

import java.util.List;

@Service
public class EquipmentService {
    private final EquipmentRepository equipmentRepository;

    public EquipmentService(EquipmentRepository equipmentRepository) {
        this.equipmentRepository = equipmentRepository;
    }

    public List<Equipment> getEquipment(){
        return equipmentRepository.findAll();
    }

    public void add(Equipment equipment){
        equipmentRepository.save(equipment);
    }

    public void delete(Long id){
        equipmentRepository.deleteById(id);
    }

}
