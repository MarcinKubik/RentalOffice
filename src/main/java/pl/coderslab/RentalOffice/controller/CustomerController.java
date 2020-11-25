package pl.coderslab.RentalOffice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.RentalOffice.entity.Customer;
import pl.coderslab.RentalOffice.repository.CustomerRepository;
import pl.coderslab.RentalOffice.service.CustomerService;

import javax.validation.Valid;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;
    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
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
                model.addAttribute("customerForContract", customer);
                return "index";
        }
    }
}
