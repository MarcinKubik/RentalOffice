package pl.coderslab.RentalOffice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.RentalOffice.entity.Contract;
import pl.coderslab.RentalOffice.entity.Customer;
import pl.coderslab.RentalOffice.repository.CustomerRepository;
import pl.coderslab.RentalOffice.service.ContractService;
import pl.coderslab.RentalOffice.service.CustomerService;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/customer")
public class
CustomerController {

    private final CustomerService customerService;
    private final ContractService contractService;
    public CustomerController(CustomerService customerService, ContractService contractService){
        this.customerService = customerService;
        this.contractService = contractService;
    }

    @GetMapping("/form")
    public String form(Model model){
        model.addAttribute("customer", new Customer());
        return "customer/form";
    }

    @PostMapping("/form")
    public String processForm(@Valid Customer customer, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            return "customer/form";
        }else{
            customerService.add(customer);
                return "index";
        }
    }

    @GetMapping("/form/{id}")
    public String edit(@PathVariable Long id, Model model){
        Optional<Customer> optionalCustomer = customerService.get(id);
        Customer customer = optionalCustomer.orElseThrow(() -> new EntityNotFoundException("Customer not found"));
        model.addAttribute("customer", customer);
        return "customer/form";
    }

    @GetMapping("/list")
    public String list(Model model){
        List<Customer> customers = customerService.getCustomers();
        model.addAttribute("customers", customers);
        return "customer/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        customerService.delete(id);
        return "customer/list";
    }

    @GetMapping("/contracts/{id}")
    public String contractsOfCustomer(@PathVariable Long id, Model model){
        List<Contract> contracts = contractService.findContractsOfCustomer(id);
        model.addAttribute("contracts", contracts);
        return "contract/list";
    }


}
