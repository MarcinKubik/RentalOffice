package pl.coderslab.RentalOffice.entity;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;

//@Entity
public class BorrowDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Pattern(regexp = "\\d+")
    private int profit;
    @OneToMany
    private List<BorrowedEquipment> borrowedEquipmentList = new ArrayList<>();
}
