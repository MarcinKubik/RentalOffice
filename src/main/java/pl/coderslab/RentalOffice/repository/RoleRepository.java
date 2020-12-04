package pl.coderslab.RentalOffice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.RentalOffice.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
