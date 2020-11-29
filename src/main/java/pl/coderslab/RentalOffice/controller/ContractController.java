package pl.coderslab.RentalOffice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.RentalOffice.entity.*;
import pl.coderslab.RentalOffice.repository.ContractRepository;
import pl.coderslab.RentalOffice.service.*;

import javax.validation.Valid;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
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
    public String addEquipment(@Valid BorrowedEquipment borrowedEquipment, BindingResult bindingResult, Model model) throws ParseException {
        if (bindingResult.hasErrors()){
            return "borrowedEquipment/form";
        }else {
            LocalDateTime borrowedTo = LocalDateTime.parse(borrowedEquipment.getBorrowedToString());
            borrowedTo = borrowedTo.plusHours(1);
            borrowedEquipment.setBorrowedTo(borrowedTo);
            CatalogPrice catalogPrice = borrowedEquipment.getEquipment().getCatalogPrice();
            LocalDateTime now = LocalDateTime.now();
            Duration duration = Duration.between(now, borrowedTo);
            if(duration.toHours() <= 2){
                borrowedEquipment.setPrice(Integer.parseInt(catalogPrice.getPriceFor2Hours()));
            }
            else if(duration.toHours() <= 5){
                borrowedEquipment.setPrice(Integer.parseInt(catalogPrice.getPriceFor2To5Hours()));
            }
            else if(duration.toHours() <= 24){
                borrowedEquipment.setPrice(Integer.parseInt(catalogPrice.getPriceFor5To24Hours()));
            }
            else if(duration.toHours() <= 48){
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
