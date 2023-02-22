package nl.muldj.garage.controller;

import nl.muldj.garage.config.UserDetailsServiceImpl;
import nl.muldj.garage.model.Account;
import nl.muldj.garage.service.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {

    @Autowired
    private CustomerServiceImpl customerService;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;


    @GetMapping("/customers")
    public ResponseEntity<List<Account>> getAllCustomers() {
        return new ResponseEntity<>(customerService.getAllCustomers(), HttpStatus.OK);

    }

    @GetMapping("/customer")
    public ResponseEntity<Optional<Account>> getCustomerAccount(){
        return new ResponseEntity<>(customerService.getCustomerAccount(userDetailsService.userEmail), HttpStatus.OK);
    }
}
