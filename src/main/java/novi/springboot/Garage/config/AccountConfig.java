package novi.springboot.Garage.config;

import novi.springboot.Garage.Repository.AccountRepository;
import novi.springboot.Garage.model.Account;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class AccountConfig {

    @Bean
    CommandLineRunner configAccounts(AccountRepository repository) {
        return args -> {
            Account jesse = new Account("Jesse",
                    "Mulder", "Van asch van Wijcklaan 20",
                    "8096AH", "Oldenbroek",
                    "0612039553", "jesse200370@gmail.com","$2y$10$VDDWWYB2R0nfgA9llHsdZecJWQadSKE8YMdrn.Yp0TkLSKmv7cKrq" , "CUSTOMER"); //wachtwoord: bootcamp
            Account mel = new Account("Mel",
                    "van Veen", "John F. Kennedylaan 8",
                    "7314PS", "Apeldoorn",
                    "0698765432", "vanveenmel11@gmail.com","$2a$10$CI6UEsCaDzIqIETP7ufhRukU/SBjdeR9oxp.hwVV9t3oD9gXv0wfm", "CUSTOMER"); //wachtwoord: belastingdienst
            Account esmee = new Account("Esmee",
                    "Lasseur", "Newtonlaan 247",
                    "3584BH", "Utrecht",
                    "0612365487", "e.lasseur@novi.nl","$2a$10$PC4TDnugAifRWPXY4UZN..KI4QqBKfuc9dGI4K93/e4GLQXYY/IKW", "MECHANIC"); //wachtwoord: test123
            Account wendy = new Account("Wendy",
                    "Van der Linder", "Apeldoornseweg 15",
                    "7233PS", "Apeldoorn",
                    "045566778", "w.vanderlinden@novi.nl", "$2a$10$hYiR9K82SexAsgTkYIZJ4OOWFnyWIRzYdJGAZcgNTqrpIEnCBekii","MANAGER"); //wachtwoord: novi


            repository.saveAll(List.of(jesse,esmee,wendy,mel));
        };


    }
}
