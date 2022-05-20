package novi.springboot.Garage.service;

import novi.springboot.Garage.model.Account;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface AccountService {

    List<Account> getAllAccounts();
    Optional<Account> getAccountById(Long id);
    Optional<Account> getAccountByEmail(String email);
}
