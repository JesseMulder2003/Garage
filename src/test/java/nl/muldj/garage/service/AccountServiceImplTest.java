package nl.muldj.garage.service;

import nl.muldj.garage.repository.AccountRepository;
import nl.muldj.garage.model.Account;
import nl.muldj.garage.service.AccountServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.any;

@SpringBootTest
public class AccountServiceImplTest {

    @Autowired
    private AccountServiceImpl accountService;

    @MockBean
    private AccountRepository accountRepository;

    @Test
    void shouldReturnMultipleAccounts(){
        //given
        Account account1 = new Account("Koos", "Veefkind", "Apeldoornseweg 10", "7314PS", "Apeldoorn",
                "0612356789", "KVeefkind@belastingdienst.nl", "Belastingdienst","MANAGER");
        Account account2 = new Account("Jesse", "Mulder", "Van asch van Wijcklaan 20", "8096AH", "Oldebroek",
                "0612039553", "jesse.mulder@solcon.nl", "hallo123", "MECHANIC");
        Account account3 = new Account("Bill", "Gates", "Evert van de Beekstraat 354", "1118 CZ", "Schiphol",
                "020 500 1500", "support@microsoft.nl", "windows64", "CUSTOMER" );

        Mockito
                .when(accountRepository.findAll())
                .thenReturn(List.of(account1, account2, account3));

        //when
        List<Account> expectedAccount = accountService.getAllAccounts();

        //then
        assertThat(expectedAccount.size()).isEqualTo(3);

    }

    @Test
    void shouldReturnAccountByID(){
        //given
        Account account = new Account("Jeremy", "Clarkson", "061205567", "CUSTOMER");

        Mockito
                .when(accountRepository.findById(any()))
                .thenReturn(Optional.of(account));

        //when
        Optional<Account> expectedAccount = accountService.getAccountById(account.getId());

        //then
        assertThat(expectedAccount.get().getId()).isEqualTo(account.getId());

    }

    @Test
    void shouldReturnAccountByEmail() {
        //given
        String email = "w.vanderlinden@novi.nl";
        Account account = new Account(
                "Wendy", "van der Linden", "Laan van Westenenk 490","7334DS", "Apeldoorn",
                "0645215421", "w.vanderlinden@novi.nl", "belasting456", "CUSTOMER");

        Mockito
                .when(accountRepository.findAccountByEmail(any()))
                .thenReturn(Optional.of(account));

        //when
        Optional<Account> exists = accountService.getAccountByEmail(email);

        //then
        assertThat(exists).isNotEmpty();

    }

}
