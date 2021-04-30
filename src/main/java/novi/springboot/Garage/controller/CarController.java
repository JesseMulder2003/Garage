package novi.springboot.Garage.controller;

import novi.springboot.Garage.model.Car;
import novi.springboot.Garage.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
public class CarController {

    @Autowired
    CarService carService;

    @GetMapping("/car")
    public ResponseEntity<Object> getAllCars() {
        return new ResponseEntity<>(carService.getAllCars(), HttpStatus.OK);
    }

    @GetMapping(value = "/carbrand")
    public ResponseEntity<Object> getCarByBrand(@RequestParam(required = false) String brand) {
        return new ResponseEntity<>(carService.getCarByBrand(brand), HttpStatus.OK);
    }

    @PostMapping(value = "/car")
    public ResponseEntity<Object> addCar(@RequestBody Car car) {

        long newId = carService.addCar(car);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newId)
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping(value = "/car/{id}")
    public ResponseEntity<Object> deleteStudent(@PathVariable("id") Integer id) {
        carService.deleteCar(id);
        return new ResponseEntity<>("Record deleted", HttpStatus.NO_CONTENT);
    }
}
