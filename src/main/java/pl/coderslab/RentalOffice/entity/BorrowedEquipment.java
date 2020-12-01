package pl.coderslab.RentalOffice.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;

@Entity
public class BorrowedEquipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    private int price;
    @NotEmpty(message = "Nie wybrano daty")
    private String borrowedFromString;
    private LocalDateTime borrowedFrom;
    @NotEmpty(message = "Nie wybrano daty")
    private String borrowedToString;
    private LocalDateTime borrowedTo;
    @OneToOne
    private Equipment equipment;

    public BorrowedEquipment(){
    }
    public BorrowedEquipment(Long id, int price, LocalDateTime borrowedTo, LocalDateTime borrowedFrom,
                             Equipment equipment) {
        this.id = id;
        this.price = price;
        this.borrowedTo = borrowedTo;
        this.borrowedFrom = borrowedFrom;
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

    public void setPrice(int price) {
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

    public String getBorrowedFromString() {
        return borrowedFromString;
    }

    public void setBorrowedFromString(String borrowedFromString) {
        this.borrowedFromString = borrowedFromString;
    }

    public LocalDateTime getBorrowedFrom() {
        return borrowedFrom;
    }

    public void setBorrowedFrom(LocalDateTime borrowedFrom) {
        this.borrowedFrom = borrowedFrom;
    }
}
