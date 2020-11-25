package pl.coderslab.RentalOffice.service;

import org.springframework.stereotype.Service;
import pl.coderslab.RentalOffice.entity.Customer;
import pl.coderslab.RentalOffice.repository.CustomerRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getCustomers(){
        return customerRepository.findAll();
    }

    public Optional<Customer> get(Long id){
        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        return optionalCustomer;
    }

    public void add(Customer customer){
        customerRepository.save(customer);
    }

    public void delete(Long id){
        customerRepository.deleteById(id);
    }

    public void update(Customer customer){
        customerRepository.save(customer);
    }
}
