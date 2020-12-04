package pl.coderslab.RentalOffice.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.coderslab.RentalOffice.entity.Employee;
import pl.coderslab.RentalOffice.entity.Role;
import pl.coderslab.RentalOffice.repository.EmployeeRepository;
import pl.coderslab.RentalOffice.repository.RoleRepository;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService{

    private final EmployeeRepository employeeRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public EmployeeService(EmployeeRepository employeeRepository, RoleRepository roleRepository,
                           BCryptPasswordEncoder passwordEncoder) {
        this.employeeRepository = employeeRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<Employee> employees(){
        return employeeRepository.findAll();
    }

    public Optional<Employee> get(Long id){
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        return employeeOptional;
    }


    public Employee findByLogin(String login){
        return employeeRepository.findByLogin(login);
    }


    public void add(Employee employee){
        employeeRepository.save(employee);
    }

    public void delete(Long id){
        employeeRepository.deleteById(id);
    }

    public void update(Employee employee){
        employeeRepository.save(employee);
    }

    public List<Employee> findLogged(){
        return employeeRepository.findLogged();
    }
}
