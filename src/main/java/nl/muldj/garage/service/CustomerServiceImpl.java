package nl.muldj.garage.service;

import nl.muldj.garage.repository.AccountRepository;
import nl.muldj.garage.exception.RecordNotFoundException;
import nl.muldj.garage.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    AccountRepository customerRepository;

    @Override
    public List<Account> getAllCustomers() {
        List<Account> allAccounts = customerRepository.findAll();
        allAccounts.removeIf(account -> !account.getRole().equals("CUSTOMER"));

        return allAccounts;
    }

    @Override
    public long addCustomer(Account customer) {
        Account newCustomer = customerRepository.save(customer);
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

    @Override
    public Optional<Account> getCustomerAccount(String email) {
        return customerRepository.findAccountByEmail(email);
    }
}

