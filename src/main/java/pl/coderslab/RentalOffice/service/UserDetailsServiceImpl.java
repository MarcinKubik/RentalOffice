package pl.coderslab.RentalOffice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import pl.coderslab.RentalOffice.entity.Employee;

public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private EmployeeService employeeService;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Employee employee = employeeService.findByLogin(login);

        if(employee == null){
            throw new UsernameNotFoundException("Could not find employee");
        }
        return new MyUserDetails(employee);
    }
}
