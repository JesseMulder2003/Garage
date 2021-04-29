package novi.springboot.Garage.service;

import novi.springboot.Garage.model.Car;
import java.util.List;

public interface CarService {

    List<Car> getAllCars();
    List<Car> getCarByBrand(String brand);
}
