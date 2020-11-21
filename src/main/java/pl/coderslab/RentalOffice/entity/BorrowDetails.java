package pl.coderslab.RentalOffice.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class BorrowDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Contract contract;
    @OneToMany
    private List<BorrowedEquipment> borrowedEquipmentList = new ArrayList<>();
}
