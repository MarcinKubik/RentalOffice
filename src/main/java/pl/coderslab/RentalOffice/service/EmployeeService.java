package pl.coderslab.RentalOffice.service;

import org.springframework.stereotype.Service;
import pl.coderslab.RentalOffice.entity.Employee;
import pl.coderslab.RentalOffice.repository.EmployeeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> employees(){
        return employeeRepository.findAll();
    }

    public Optional<Employee> get(Long id){
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        return employeeOptional;
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

    public Employee findLogged(){
        return employeeRepository.findLogged();
    }
}
