package novi.springboot.Garage.service;

import novi.springboot.Garage.Repository.CustomerRepository;
import novi.springboot.Garage.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }
}
