package novi.springboot.Garage.Repository;

import novi.springboot.Garage.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {


}
