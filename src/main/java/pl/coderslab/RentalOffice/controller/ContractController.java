package pl.coderslab.RentalOffice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.RentalOffice.entity.Contract;
import pl.coderslab.RentalOffice.entity.Customer;
import pl.coderslab.RentalOffice.entity.Employee;
import pl.coderslab.RentalOffice.repository.ContractRepository;
import pl.coderslab.RentalOffice.service.ContractService;
import pl.coderslab.RentalOffice.service.CustomerService;
import pl.coderslab.RentalOffice.service.EmployeeService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/contract")
public class ContractController {

    private final ContractService contractService;
    private final EmployeeService employeeService;
    private final CustomerService customerService;
    public ContractController(ContractService contractService, EmployeeService employeeService, CustomerService customerService){
        this.contractService = contractService;
        this.employeeService = employeeService;
        this.customerService = customerService;
    }

    //dodaję pracownika do umowy
    @ModelAttribute("employee")
    public Employee employee(){
        return employeeService.findLogged();
    }

    @ModelAttribute("customers")
    public List<Customer> customers(){
        return customerService.getCustomers();
    }

    @GetMapping("/form")
    public String form(Model model){
        model.addAttribute("contract", new Contract());
        return "contract/form";
    }

    @PostMapping("/form")
    public String processForm(@Valid Contract contract, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "contract/form";
        }else {
            contractService.add(contract);
            return "index";
        }
    }
}
