package novi.springboot.Garage.service;

import novi.springboot.Garage.model.Car;
import novi.springboot.Garage.model.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {

    List<Customer> getAllCustomers();
    long addCustomer(Customer customer);
    void deleteCustomer(long id);
}
