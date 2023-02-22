package nl.muldj.garage.customer;

import nl.muldj.garage.repository.AccountRepository;
import nl.muldj.garage.model.Account;
import nl.muldj.garage.service.CustomerServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class CustomerService {

    @Autowired
    private CustomerServiceImpl customerService;


    @Autowired
    private AccountRepository customerRepository;


    @Test
    void shouldReturnMultipleCustomers() {
        //given
        Account customer1 = new Account("Elon", "Musk", "0137999525", "CUSTOMER");
        Account customer2 = new Account("Jeff", "Bezos", "02069220880", "CUSTOMER");
        Account customer3 = new Account("Esmee", "Lasseur", "0303073200", "CUSTOMER");
        int oldListSize = customerRepository.findAll().size();
        customerRepository.saveAll(List.of(customer1, customer2, customer3));

        //when
        List<Account> expectedCustomers = customerService.getAllCustomers();

        //then
        assertThat(expectedCustomers.size()).isEqualTo(oldListSize + 3);


    }

    @Test
    void shouldReturnAddedCustomer(){
        //given
        Account customer = new Account("Wendy", "Van der Linden", "Laan van Westenenk 490","7334DS",
                "Apeldoorn", "0645215421","w.vanderlinden@novi.nl", "Duaal", "CUSTOMER");

        //when
        customerService.addCustomer(customer);
        List<Account> expectedCustomer = customerRepository.findAll();

        //then
        assertThat(expectedCustomer.get(expectedCustomer.size() - 1).getFirstName()).isEqualTo("Wendy");
    }

    @Test
    void shouldNotReturnCustomer(){
        //given
        Account customer = new Account("Marco", "Borsato", "0612345678", "CUSTOMER");
        int oldListSize = customerRepository.findAll().size();
        customerService.addCustomer(customer);

        //when
        customerService.deleteCustomer(customer.getId());
        List<Account> expectedCustomer = customerRepository.findAll();

        //then
        assertThat(expectedCustomer.size()).isEqualTo(oldListSize);
    }

}
