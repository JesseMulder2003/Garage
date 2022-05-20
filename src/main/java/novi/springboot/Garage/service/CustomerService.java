package novi.springboot.Garage.service;

import novi.springboot.Garage.model.Account;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CustomerService {

    List<Account> getAllCustomers();
    long addCustomer(Account customer);
    void deleteCustomer(long id);
    Optional<Account> getCustomerAccount(String email);
}
