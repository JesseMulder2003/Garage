package nl.muldj.garage.service;

import nl.muldj.garage.model.Car;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CarService {

    List<Car> getAllCars();
    List<Car> getCarByBrand(String brand);
    String addCar(Car car);
    void deleteCar(long id);
}
