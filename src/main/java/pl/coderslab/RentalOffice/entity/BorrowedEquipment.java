package pl.coderslab.RentalOffice.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;

@Entity
public class BorrowedEquipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @NotNull
    @Pattern(regexp = "\\d+")
    private String price;
    @NotNull(message = "Nie może być null")
    private String borrowedToString;
    private LocalDateTime borrowedTo;
    @OneToOne
    private Equipment equipment;

    public BorrowedEquipment(){
    }
    public BorrowedEquipment(Long id, String price, LocalDateTime borrowedTo, Equipment equipment) {
        this.id = id;
        this.price = price;
        this.borrowedTo = borrowedTo;
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public LocalDateTime getBorrowedTo() {
        return borrowedTo;
    }

    public void setBorrowedTo(LocalDateTime borrowedTo) {
        this.borrowedTo = borrowedTo;
    }

    public String getBorrowedToString() {
        return borrowedToString;
    }

    public void setBorrowedToString(String borrowedToString) {
        this.borrowedToString = borrowedToString;
    }
}
