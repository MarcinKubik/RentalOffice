package pl.coderslab.RentalOffice.entity;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "devices")
public class Equipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Size(min = 3)
    private String name;
    @NotNull
    @Pattern(regexp = "\\d+")
    private int value;
    @NotBlank
    @Size(min = 20)
    private String description;
    private LocalDateTime borrowedTo;
    private boolean available;
    @OneToOne
    private CatalogPrice catalogPrice;
    
    public Equipment(){

    }

    public Equipment(Long id, String name, int value, String description, LocalDateTime borrowedTo, boolean available, CatalogPrice catalogPrice) {
        this.id = id;
        this.name = name;
        this.value = value;
        this.description = description;
        this.borrowedTo = borrowedTo;
        this.available = available;
        this.catalogPrice = catalogPrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getBorrowedTo() {
        return borrowedTo;
    }

    public void setBorrowedTo(LocalDateTime borrowedTo) {
        this.borrowedTo = borrowedTo;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public CatalogPrice getCatalogPrice() {
        return catalogPrice;
    }

    public void setCatalogPrice(CatalogPrice catalogPrice) {
        this.catalogPrice = catalogPrice;
    }
}
