package pl.coderslab.RentalOffice.entity;

import org.hibernate.annotations.Immutable;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "equipment")
public class Equipment {
    // wszystkie pola private final, bez setterów klasa immutable
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "not null")
    @Size(min = 3)
    private String name;
    @NotNull
    @Pattern(regexp = "\\d+")
    private String value;
    @NotBlank
    @Size(min = 20)
    private String description;
    @NotNull
    @Size(min = 2)
    private String producent;
    private boolean available;
    @OneToOne
    private CatalogPrice catalogPrice;

    public Equipment(){

    }

    public Equipment(Long id, String name, String value, String description, String producent, CatalogPrice catalogPrice) {
        this.id = id;
        this.name = name;
        this.value = value;
        this.description = description;
        this.producent = producent;
        this.catalogPrice = catalogPrice;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    public String getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }

    public CatalogPrice getCatalogPrice() {
        return catalogPrice;
    }

    public String getProducent() {
        return producent;
    }

    public boolean getAvailable(){
         return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public void setCatalogPrice(CatalogPrice catalogPrice) {
        this.catalogPrice = catalogPrice;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setProducent(String producent) {
        this.producent = producent;
    }
}
