package nl.muldj.garage.service;

import nl.muldj.garage.repository.AccountRepository;
import nl.muldj.garage.repository.CarRepository;
import nl.muldj.garage.config.UserDetailsServiceImpl;
import nl.muldj.garage.exception.RecordNotFoundException;
import nl.muldj.garage.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    CarRepository carRepository;

    @Autowired
    AccountRepository customerRepository;

    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @Override
    public List<Car> getAllCars() { return carRepository.findAll(); }

    @Override
    public List<Car> getCarByBrand(String brand) {
        if (brand == null || brand.isEmpty())
            return carRepository.findAll();
        else {
            return carRepository.findByMerkIs(brand);
        }
    }

    @Override
    public String addCar(Car car) {
        car.setCustomerId(customerRepository.findAccountByEmail(userDetailsService.userEmail).get().getId());
        Car newCar = carRepository.save(car);
        return newCar.toString();
    }

    @Override
    public void deleteCar(long id) {
        if (carRepository.existsById(id)) {
            carRepository.deleteById(id);
        }
        else {
            throw new RecordNotFoundException();
        }
    }

    public List<Car> getCarsByCustomer(Long id) {
        return carRepository.findByCustomerId(id);
    }

    public Optional<Car> getCarById(Long id) {
        return carRepository.findById(id);
    }
}
