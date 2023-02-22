package nl.muldj.garage.config;

import nl.muldj.garage.model.Account;
import nl.muldj.garage.service.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    AccountServiceImpl accountService;

    public String userEmail;

    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Account> optionalAccount = accountService.getAccountByEmail(email);

        if (optionalAccount.isEmpty()) {
            throw new UsernameNotFoundException("User Name is not Found");
        }

        Account account = optionalAccount.get();

        UserDetails user = User.builder()
                .username(account.getEmail())
                .password(account.getPassword())
                .roles(account.getRole())
                .build();


        userEmail = account.getEmail();


        return user;
    }
}