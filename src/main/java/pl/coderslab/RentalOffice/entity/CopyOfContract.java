package pl.coderslab.RentalOffice.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "copies_of_contracts")
public class CopyOfContract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int profit;
    private String customer;
    private String employee;

    @NotEmpty
    @Size(max = 1000)
    private String borrowDetails;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getProfit() {
        return profit;
    }

    public void setProfit(int profit) {
        this.profit = profit;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    public String getBorrowDetails() {
        return borrowDetails;
    }

    public void setBorrowDetails(String borrowDetails) {
        this.borrowDetails = borrowDetails;
    }
}
