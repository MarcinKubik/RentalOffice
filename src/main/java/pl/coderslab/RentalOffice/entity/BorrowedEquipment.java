package pl.coderslab.RentalOffice.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class BorrowedEquipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @OneToOne
    private Equipment equipment;
    @NotNull
    int price;

    public BorrowedEquipment(){

    }
    public BorrowedEquipment(Long id, Equipment equipment, int price) {
        this.id = id;
        this.equipment = equipment;
        this.price = price;
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

    public void setPrice(int price) {
        this.price = price;
    }
}
