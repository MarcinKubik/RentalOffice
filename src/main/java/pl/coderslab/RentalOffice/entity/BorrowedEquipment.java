package pl.coderslab.RentalOffice.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class BorrowedEquipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    int price;
    @OneToOne
    private Equipment equipment;

    public BorrowedEquipment(){
    }
    public BorrowedEquipment(Long id, int price, Equipment equipment) {
        this.id = id;
        this.price = price;
        this.equipment = equipment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    public int getPrice() {
        return price;
    }
}
