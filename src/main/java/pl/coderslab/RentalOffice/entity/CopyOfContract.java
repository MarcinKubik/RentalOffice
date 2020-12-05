package pl.coderslab.RentalOffice.entity;

import javax.persistence.*;
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

    private String borrowDetails;
}
