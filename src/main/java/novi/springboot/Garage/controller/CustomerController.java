package novi.springboot.Garage.controller;

import novi.springboot.Garage.model.Car;
import novi.springboot.Garage.model.Customer;
import novi.springboot.Garage.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {

    @Autowired
    CustomerService customerService;


    @GetMapping("/customer")
    public ResponseEntity<Object> getAllCustomers() {
        return new ResponseEntity<>(customerService.getAllCustomers(), HttpStatus.OK);
    }

    //postmapping om een klant aan te maken
    @PostMapping(value = "/customers")
    public ResponseEntity<Object> addStudent(@RequestBody Customer customer) {

        long newId = customerService.addCustomer(customer);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newId)
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping(value = "/customer/{id}")
    public ResponseEntity<Object> deleteCustomer(@PathVariable("id") Integer id) {
        customerService.deleteCustomer(id);
        return new ResponseEntity<>("Record deleted", HttpStatus.NO_CONTENT);
    }
}
