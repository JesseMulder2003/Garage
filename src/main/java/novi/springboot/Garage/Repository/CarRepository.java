package novi.springboot.Garage.Repository;

import novi.springboot.Garage.model.Car;
import novi.springboot.Garage.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {

    List<Car> findByBrandIs(String name);
}
