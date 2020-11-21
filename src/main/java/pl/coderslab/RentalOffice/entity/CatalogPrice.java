package pl.coderslab.RentalOffice.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
public class CatalogPrice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Pattern(regexp = "\\d+")
    private int priceFor2Hours;
    @NotNull
    @Pattern(regexp = "\\d+")
    private int priceFor2To5Hours;
    @NotNull
    @Pattern(regexp = "\\d+")
    private int priceFor5To24Hours;
    @NotNull
    @Pattern(regexp = "\\d+")
    private int priceFor2Days;

    public CatalogPrice(){

    }

    public int getPriceFor2Hours() {
        return priceFor2Hours;
    }

    public void setPriceFor2Hours(int priceFor2Hours) {
        this.priceFor2Hours = priceFor2Hours;
    }

    public int getPriceFor2To5Hours() {
        return priceFor2To5Hours;
    }

    public void setPriceFor2To5Hours(int priceFor2To5Hours) {
        this.priceFor2To5Hours = priceFor2To5Hours;
    }

    public int getPriceFor5To24Hours() {
        return priceFor5To24Hours;
    }

    public void setPriceFor5To24Hours(int priceFor5To24Hours) {
        this.priceFor5To24Hours = priceFor5To24Hours;
    }

    public int getPriceFor2Days() {
        return priceFor2Days;
    }

    public void setPriceFor2Days(int priceFor2Days) {
        this.priceFor2Days = priceFor2Days;
    }
}
