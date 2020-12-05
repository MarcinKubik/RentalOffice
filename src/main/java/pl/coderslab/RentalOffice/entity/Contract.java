package pl.coderslab.RentalOffice.entity;

import org.springframework.security.core.parameters.P;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "contracts")
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /*@NotNull  //do przemyślenia
    @Pattern(regexp = "\\d+\\/(20)[2-9]{1}[0-9]{1}")
    @Column(unique = true)
    private String contractNumber;*/
    private int profit;
    @ManyToOne
    private Employee employee;
    @ManyToOne
    private Customer customer;
    @OneToMany
    @JoinColumn(name = "id_contract")
    private List<BorrowedEquipment> borrowedEquipmentList = new ArrayList<>();



    public Contract(){

    }

    public Contract(Long id, int profit,
                    Employee employee, Customer customer, List<BorrowedEquipment> borrowedEquipmentList){
        this.id = id;
        //this.contractNumber = contractNumber; // rozważyć możliwość dodania w przyszłości
        this.profit = profit;
        this.employee = employee;
        this.customer = customer;
        this.borrowedEquipmentList = borrowedEquipmentList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /*public String getContractNumber() {
        return contractNumber;
    }*/

   /* public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber;
    }*/

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

    public int getProfit() {
        return profit;
    }

    public void setProfit(int profit) {
        this.profit = profit;
    }

    public List<BorrowedEquipment> getBorrowedEquipmentList() {
        return borrowedEquipmentList;
    }

    public void setBorrowedEquipmentList(List<BorrowedEquipment> borrowedEquipmentList) {
        this.borrowedEquipmentList = borrowedEquipmentList;
    }
}
