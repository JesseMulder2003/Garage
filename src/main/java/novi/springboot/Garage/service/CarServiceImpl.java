package novi.springboot.Garage.service;

import novi.springboot.Garage.Repository.CarRepository;
import novi.springboot.Garage.model.Car;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CarServiceImpl implements CarService {

    @Autowired
    CarRepository carRepository;

    @Override
    public List<Car> getAllCars() { return carRepository.findAll(); }

    @Override
    public List<Car> getCarByBrand(String brand) {
        if (brand == null || brand.isEmpty())
            return carRepository.findAll();
        else {
            return carRepository.findByBrandIs(brand);
        }
    }
}
