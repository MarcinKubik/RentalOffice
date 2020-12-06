package pl.coderslab.RentalOffice.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "workers")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Pattern(regexp = "[A-ZÓŹŻĆŁĆ]{1}[a-zóżźćąęłń]{2,}", message = "Podaj poprawne imię")
    private String name;
    @NotNull
    @Pattern(regexp = "[A-ZÓŹŻĆŁŚĆ]{1}[a-zóżźćąęłśń]{2,}", message = "Podaj poprawne nazwisko")
    private String surname;
    @NotNull
    @Column(unique = true, nullable = false)
    @Size(min = 3, message = "Minimum 3 znaki")
    private String login;
    @NotNull
    @Pattern(regexp = "\\S{8,}", message = "Hasło musi zawierać co najmniej 8 znaków")
    private String password;
    private boolean enabled;
    @OneToMany(mappedBy = "employee")
    private List<Contract> contracts = new ArrayList<>();
//cascade = CascadeType.ALL,
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "employee_role", joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    public Employee(){

    }

    public Employee(Long id, String name, String surname, String login, String password, boolean enabled, List<Contract> contracts) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.password = password;
        this.enabled = enabled;
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

    public boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
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

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return String.valueOf(id);
    }
}
