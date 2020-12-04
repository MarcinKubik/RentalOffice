package pl.coderslab.RentalOffice.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.RentalOffice.entity.*;
import pl.coderslab.RentalOffice.service.*;

import javax.validation.Valid;
import java.text.ParseException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/contract")
public class ContractController {

    private final ContractService contractService;
    private final EmployeeService employeeService;
    private final CustomerService customerService;
    private final EquipmentService equipmentService;
    private final BorrowedEquipmentService borrowedEquipmentService;
    public ContractController(ContractService contractService, EmployeeService employeeService,
                              CustomerService customerService, EquipmentService equipmentService,
                              BorrowedEquipmentService borrowedEquipmentService){
        this.contractService = contractService;
        this.employeeService = employeeService;
        this.customerService = customerService;
        this.equipmentService = equipmentService;
        this.borrowedEquipmentService = borrowedEquipmentService;
    }

    //dodaję pracownika do umowy
    @ModelAttribute("employee")
    public Employee employee(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String login;
        if (principal instanceof UserDetails) {
            login = ((UserDetails)principal).getUsername();
        } else {
            login = principal.toString();
        }
        return employeeService.findByLogin(login);
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
        if(!borrowedEquipment.getBorrowedFromString().equals("") && !borrowedEquipment.getBorrowedToString().equals("")){
            LocalDateTime start = LocalDateTime.parse(borrowedEquipment.getBorrowedFromString());
            LocalDateTime end = LocalDateTime.parse(borrowedEquipment.getBorrowedToString());

            if(start.isBefore(LocalDateTime.now().minusMinutes(1))){  // minuta na akceptację jeśli wybrano chwilę obecną
                FieldError error = new FieldError("borrowedEquipment", "borrowedToString", "Wybrano datę z przeszłości");
                bindingResult.addError(error);
            }

            if(start.isAfter(end) || start.isEqual(end)){
                FieldError error = new FieldError("borrowedEquipment", "borrowedToString", "Zła kolejność dat");
                bindingResult.addError(error);
            }

            if(Duration.between(start, end).toMinutes() > 2880){
                FieldError error = new FieldError("borrowedEquipment", "borrowedToString", "Maksymalnie 48 godzin!");
                bindingResult.addError(error);
            }
        }
        if (bindingResult.hasErrors()){
            model.addAttribute("borrowedEquipment", borrowedEquipment);
            return "borrowedEquipment/form";
        }else {
            LocalDateTime borrowedFrom = LocalDateTime.parse(borrowedEquipment.getBorrowedFromString());
            LocalDateTime borrowedTo = LocalDateTime.parse(borrowedEquipment.getBorrowedToString());
            borrowedEquipment.setBorrowedFrom(borrowedFrom);
            borrowedEquipment.setBorrowedTo(borrowedTo);
            CatalogPrice catalogPrice = borrowedEquipment.getEquipment().getCatalogPrice();
            Duration duration = Duration.between(borrowedFrom, borrowedTo);
            if(duration.toMinutes() <= 120){
                borrowedEquipment.setPrice(Integer.parseInt(catalogPrice.getPriceFor2Hours()));
            }
            else if(duration.toMinutes() <= 300){
                borrowedEquipment.setPrice(Integer.parseInt(catalogPrice.getPriceFor2To5Hours()));
            }
            else if(duration.toMinutes() <= 1440){
                borrowedEquipment.setPrice(Integer.parseInt(catalogPrice.getPriceFor5To24Hours()));
            }
            else if(duration.toMinutes() <= 2880){
                borrowedEquipment.setPrice(Integer.parseInt(catalogPrice.getPriceFor2Days()));
            }
            borrowedEquipment.getEquipment().setAvailable(false);  //sprzęt staje się niedostępny

            borrowedEquipmentService.add(borrowedEquipment);
            Contract contract = contractService.findLastAdded();
            contract.getBorrowedEquipmentList().add(borrowedEquipment);
            int profit = 0;
            for(BorrowedEquipment b : contract.getBorrowedEquipmentList()){
                profit += b.getPrice();
            }
            contract.setProfit(profit);
           
            contractService.update(contract);
            List<Equipment> availableEquipment = equipmentService.getAvailableEquipment();
            model.addAttribute("availableEquipment", availableEquipment);
            model.addAttribute("borrowedEquipment", new BorrowedEquipment());
            return "borrowedEquipment/form";
        }
    }


    @GetMapping("/list")
    public String list(Model model){
        List<Contract> contracts = contractService.getContracts();
        model.addAttribute("contracts", contracts);
        return "contract/list";
    }

    @GetMapping("/borrowedEquipment/{id}")
    public String borrowedEquipmentForContract(@PathVariable Long id, Model model){
        List<BorrowedEquipment> borrowedEquipmentList = borrowedEquipmentService.equipmentForContract(id);
        model.addAttribute("borrowedEquipmentList", borrowedEquipmentList);
        return "borrowedEquipment/list";
    }

}
