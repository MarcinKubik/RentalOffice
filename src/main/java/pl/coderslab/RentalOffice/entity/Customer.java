package pl.coderslab.RentalOffice.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Pattern(regexp = "[A-Z]{1}[a-z]{2,}")
    private String name;
    @NotNull
    @Pattern(regexp = "[A-Z]{1}[a-z]{2,}")
    private String surname;
    @Pattern(regexp = "[_a-zA-Z0-9-]+(\\.[_a-zA-Z0-9-]+)*@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*\\.([a-zA-Z]{2,}){1}")
    private String email;
    @NotNull
    @Pattern(regexp = "[0-9]{9}")
    private int phoneNumber;
    @OneToMany(mappedBy = "customer")
    private List<Contract> contracts = new ArrayList<>();
    @NotNull
    @Pattern(regexp = "[A-Z]{1}[a-z]{2,}")
    private String city;
    @NotNull
    @Pattern(regexp = "[A-Z]{1}[a-z]{2,}")
    private String street;
    @NotNull
    @Pattern(regexp = "\\d+")
    private int number;


    public Customer() {
    }

    public Customer(Long id, String name, String surname, String email, int phoneNumber, List<Contract> contracts, String city, String street, int number) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.contracts = contracts;
        this.city = city;
        this.street = street;
        this.number = number;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
