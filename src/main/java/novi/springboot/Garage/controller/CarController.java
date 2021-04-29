package novi.springboot.Garage.controller;

import novi.springboot.Garage.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}
