package pl.coderslab.RentalOffice.controller;

import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import pl.coderslab.RentalOffice.entity.BorrowedEquipment;
import pl.coderslab.RentalOffice.entity.Contract;
import pl.coderslab.RentalOffice.entity.Equipment;
import pl.coderslab.RentalOffice.repository.CopyOfContractRepository;
import pl.coderslab.RentalOffice.service.*;
import org.junit.Test;

import static org.junit.Assert.*;


import java.time.LocalDateTime;

public class ContractControllerTest {

    private ContractController contractController;
    @Autowired
    private ContractService contractService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private EquipmentService equipmentService;
    @Autowired
    private BorrowedEquipmentService borrowedEquipmentService;
    @Autowired
    private CopyOfContractRepository copyOfContractRepository;


    public ContractControllerTest() {

    }


    @Before
    public void setup() {
       this.contractController = new ContractController(contractService, employeeService, customerService, equipmentService, borrowedEquipmentService, copyOfContractRepository);
    }


    @Test
    public void addEquipment() {

        LocalDateTime from = LocalDateTime.of(2021, 1, 30, 19, 0, 0);
        LocalDateTime to = LocalDateTime.of(2021, 1, 31, 19, 0, 0);
        //Equipment equipment = equipmentService.get(Long.valueOf(1)).get();
        BorrowedEquipment borrowedEquipment = new BorrowedEquipment();
       // borrowedEquipment.setEquipment(equipment);
        borrowedEquipment.setBorrowedFrom(from);
        borrowedEquipment.setBorrowedTo(to);


        assertTrue(contractController != null);
    }
}