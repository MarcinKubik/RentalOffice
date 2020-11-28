package pl.coderslab.RentalOffice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.RentalOffice.entity.*;
import pl.coderslab.RentalOffice.repository.ContractRepository;
import pl.coderslab.RentalOffice.service.ContractService;
import pl.coderslab.RentalOffice.service.CustomerService;
import pl.coderslab.RentalOffice.service.EmployeeService;
import pl.coderslab.RentalOffice.service.EquipmentService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/contract")
public class ContractController {

    private final ContractService contractService;
    private final EmployeeService employeeService;
    private final CustomerService customerService;
    private final EquipmentService equipmentService;
    public ContractController(ContractService contractService, EmployeeService employeeService,
                              CustomerService customerService, EquipmentService equipmentService){
        this.contractService = contractService;
        this.employeeService = employeeService;
        this.customerService = customerService;
        this.equipmentService = equipmentService;
    }

    //dodaję pracownika do umowy
    @ModelAttribute("employee")
    public List<Employee> employee(){
        return employeeService.findLogged();
    }

    @ModelAttribute("customers")
    public List<Customer> customers(){
        return customerService.getCustomers();
    }

    @ModelAttribute("availableEquipment")
    public List<Equipment> availableEquipment(){
        return equipmentService.getAvailableEquipment();
    }

    @GetMapping("/form")
    public String form(Model model){
        model.addAttribute("contract", new Contract());
        return "contract/form";
    }

    @PostMapping("/form")
    public String processForm(@Valid Contract contract, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            return "contract/form";
        }else {
            contractService.add(contract);
            model.addAttribute("borrowedEquipment", new BorrowedEquipment());
            return "borrowedEquipment/form";
        }
    }

    @PostMapping("/addEquipment")
    public String addEquipment(@Valid BorrowedEquipment borrowedEquipment, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            return "borrowedEquipment/form";
        }else {
            //dodać serwis
            Contract contract = contractService.findLastAdded();
            //contract.getBorrowedEquipmentList().add()
            return "index";
        }
    }

    @GetMapping("/list")
    public String list(Model model){
        List<Contract> contracts = contractService.getContracts();
        model.addAttribute("contracts", contracts);
        return "contract/list";
    }

}
