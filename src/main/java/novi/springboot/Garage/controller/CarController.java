package novi.springboot.Garage.controller;

import novi.springboot.Garage.model.Car;
import novi.springboot.Garage.service.CarService;
import novi.springboot.Garage.service.CarServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class CarController {

    @Autowired
    CarServiceImpl carService;

    @GetMapping("/cars")
    public ResponseEntity<Object> getAllCars() {
        return new ResponseEntity<>(carService.getAllCars(), HttpStatus.OK);
    }

    @GetMapping(value = "/car/brand")
    public ResponseEntity<Object> getCarByBrand(@RequestParam(required = false) String brand) {
        return new ResponseEntity<>(carService.getCarByBrand(brand), HttpStatus.OK);
    }

    @PostMapping(value = "/car")
    public ResponseEntity<String> addCar(@RequestBody Car car) {

        String newId = carService.addCar(car);

        return new ResponseEntity<>(newId, HttpStatus.OK);
    }

    @DeleteMapping(value = "/car/{id}")
    public ResponseEntity<Object> deleteCar(@PathVariable("id") Long id) {
        carService.deleteCar(id);
        return new ResponseEntity<>("Record deleted", HttpStatus.NO_CONTENT);
    }

    @GetMapping("car/{id}")
    public ResponseEntity<Optional<Car>> getCarById(@PathVariable("id") Long id){
        return new ResponseEntity<>(carService.getCarById(id), HttpStatus.OK);
    }

    @GetMapping("car/customer/{id}")
    public ResponseEntity<List<Car>> getCarsByCustomerId(@PathVariable("id") Long id){
       return new ResponseEntity<>(carService.getCarsByCustomer(id), HttpStatus.OK);

    }
}
