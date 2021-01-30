package pl.coderslab.RentalOffice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.coderslab.RentalOffice.entity.Role;
import pl.coderslab.RentalOffice.repository.RoleRepository;

import java.util.List;

@Controller
public class StartController {

    private final RoleRepository roleRepository;

    public StartController(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @GetMapping("/")
    public String start(Model model){
        //adding roles if dont exist
        List<Role> roles = roleRepository.findAll();
        if(roles.size() == 0){
            Role roleAdmin = new Role();
            roleAdmin.setId(1);
            roleAdmin.setName("ROLE_ADMIN");
            Role roleUser = new Role();
            roleUser.setId(1);
            roleUser.setName("ROLE_EMPLOYEE");
            roleRepository.save(roleAdmin);
            roleRepository.save(roleUser);
        }
        return "index";
    }

}
