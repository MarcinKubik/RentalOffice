package pl.coderslab.RentalOffice.entity;

import org.springframework.security.core.parameters.P;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "contracts")
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Pattern(regexp = "\\d+\\/(20)[2-9]{1}[0-9]{1}")
    private String contractNumber;
    @Pattern(regexp = "\\d+")
    private int profit;
    @ManyToOne
    private Employee employee;
    @ManyToOne
    private Customer customer;
    @OneToOne
    private BorrowDetails borrowDetails;


    public Contract(){

    }

    public Contract(Long id, String contractNumber, int profit, Employee employee, Customer customer, BorrowDetails borrowDetails){
        this.id = id;
        this.contractNumber = contractNumber;
        this.profit = profit;
        this.employee = employee;
        this.customer = customer;
        this.borrowDetails = borrowDetails;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber;
    }

    public int getProfit() {
        return profit;
    }

    public void setProfit(int profit) {
        this.profit = profit;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public BorrowDetails getBorrowDetails() {
        return borrowDetails;
    }

    public void setBorrowDetails(BorrowDetails borrowDetails) {
        this.borrowDetails = borrowDetails;
    }
}
