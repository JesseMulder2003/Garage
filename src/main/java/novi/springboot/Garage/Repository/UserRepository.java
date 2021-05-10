package novi.springboot.Garage.Repository;


import novi.springboot.Garage.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<AppUser, String> {
}
