package novi.springboot.Garage.controller;

import novi.springboot.Garage.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/")
    public String sayhello(){return "nu werkt het wel";}


    @GetMapping("/customer")
    public ResponseEntity<Object> getcustomer(@RequestParam(required = false) String name) {
        return new ResponseEntity<>
    }

}
