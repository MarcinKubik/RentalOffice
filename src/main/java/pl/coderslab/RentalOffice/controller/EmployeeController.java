package pl.coderslab.RentalOffice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.RentalOffice.entity.Contract;
import pl.coderslab.RentalOffice.entity.Employee;
import pl.coderslab.RentalOffice.entity.Role;
import pl.coderslab.RentalOffice.repository.RoleRepository;
import pl.coderslab.RentalOffice.service.ContractService;
import pl.coderslab.RentalOffice.service.EmployeeService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;
    private final RoleRepository roleRepository;
    private final ContractService contractService;
    BCryptPasswordEncoder bCryptPasswordEncoder;

    public EmployeeController(EmployeeService employeeService, RoleRepository roleRepository, ContractService contractService,
                              BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.employeeService = employeeService;
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.contractService = contractService;
    }

    @GetMapping("/form")
    public String form(Model model){
        model.addAttribute("employee", new Employee());
        return "employee/form";
    }

    @PostMapping("/form")
    public String processForm(@Valid Employee employee, BindingResult bindingResult, Model model){
        List<Employee> employees = employeeService.employees();
        for(Employee e : employees){
            if (e.getLogin().equals(employee.getLogin())){
                FieldError error = new FieldError("employee", "login", "Login istnieje w bazie danych");
                bindingResult.addError(error);
            }
        }
        if(bindingResult.hasErrors()){
            return "employee/form";
        }else {

            Set<Role> roles = new HashSet<>();
            Role role = roleRepository.findByName("ROLE_EMPLOYEE");
            roles.add(role);
            employee.setEnabled(true);
            employee.setRoles(roles);
            String password = employee.getPassword();
            String hashPassword = bCryptPasswordEncoder.encode(password);
            employee.setPassword(hashPassword);
            employeeService.add(employee);
        }
        return "index";
    }

    @GetMapping("/addFirstEmployee")
    public String addFirstEmployee(Model model){
        List<Employee> all = employeeService.employees();
        if(all.size() != 0){
            return "employee/firstEmployeeExist";
        }else {
            model.addAttribute("employee", new Employee());
            return "employee/formAdmin";
        }
    }

    @PostMapping("/addFirstEmployee")
    public String processFirstEmployee(@Valid Employee employee, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            return "employee/form";
        }else{
            Set<Role> roles = new HashSet<>();
            Role role = roleRepository.findByName("ROLE_ADMIN");
            roles.add(role);
            employee.setEnabled(true);
            employee.setRoles(roles);
            String password = employee.getPassword();
            String hashPassword = bCryptPasswordEncoder.encode(password);
            employee.setPassword(hashPassword);
            employeeService.add(employee);
        }
        return "index";
    }

    @GetMapping("/list")
    public String list(Model model){
        List<Employee> employeeList = employeeService.employees();
        model.addAttribute("employeeList", employeeList);
        return "employee/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id, Model model){
        Optional<Employee> optionalEmployee = employeeService.get(id);
        Employee employee = optionalEmployee.orElse(null);
        if(employee == null){
            return "employee/problem";
        }
        else {
            Set<Role> roles = new HashSet<>();
            Role role = roleRepository.findByName("ROLE_ADMIN");
            if (employee.getRoles().contains(role)){
                return "employee/problem";
            }else {
                List<Contract> contracts = contractService.findContractsOfEmployee(id);
                for (Contract c : contracts){
                    contractService.delete(c.getId());
                }
                employeeService.delete(id);
                return "redirect:/employee/list";
            }
        }
    }
}
