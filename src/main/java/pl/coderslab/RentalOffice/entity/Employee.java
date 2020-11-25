package pl.coderslab.RentalOffice.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "workers")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Pattern(regexp = "[A-ZÓŹŻĆ]{1}[a-zóżźćąę]{2,}")
    private String name;
    @NotNull
    @Pattern(regexp = "[A-ZÓŹŻĆ]{1}[a-zóżźćąę]{2,}")
    private String surname;
    @NotNull
    @Column(unique = true)
    private String login;
    @NotNull
    @Pattern(regexp = "\\S{8,}")
    private String password;
    @NotNull
    private boolean isLogged;
    @OneToMany(mappedBy = "employee")
    private List<Contract> contracts = new ArrayList<>();

    public Employee(){

    }
//public Employee(Long id, @NotNull @Pattern(regexp = "[A-Z]{1}[a-z]{2,}") String name, @NotNull @Pattern(regexp = "[A-Z]{1}[a-z]{2,}") String surname,
// @NotNull String login, @NotNull @Pattern(regexp = "\\S{8,}") String password, List<Contract> contracts) {
    // sprawdzić czy to jest poprawne
    public Employee(Long id, String name, String surname, String login, String password, boolean isLogged, List<Contract> contracts) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.password = password;
        this.isLogged = isLogged;
        this.contracts = contracts;
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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isLogged() {
        return isLogged;
    }

    public void setLogged(boolean logged) {
        isLogged = logged;
    }

    public List<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }

    public String getFullName(){
        return name + " " + surname;
    }
}
