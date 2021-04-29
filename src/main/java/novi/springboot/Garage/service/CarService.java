package novi.springboot.Garage.service;

import novi.springboot.Garage.model.Car;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CarService {

    List<Car> getAllCars();
    List<Car> getCarByBrand(String brand);
}
