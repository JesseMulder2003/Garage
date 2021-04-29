package novi.springboot.Garage.Repository;

import novi.springboot.Garage.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    List<Car> findByMerkIs(String brand);
}
