package novi.springboot.Garage.service;

import novi.springboot.Garage.Repository.CustomerRepository;
import novi.springboot.Garage.exception.RecordNotFoundException;
import novi.springboot.Garage.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public List<Customer> getAllCustomers() {

        return customerRepository.findAll();
    }

    @Override
    public long addCustomer(Customer customer) {
        Customer newCustomer = customerRepository.save(customer);
        return newCustomer.getId();
    }

    @Override
    public void deleteCustomer(long id) {
        if (customerRepository.existsById(id)) {
            customerRepository.deleteById(id);
        }
        else {
            throw new RecordNotFoundException();
        }
    }
}

