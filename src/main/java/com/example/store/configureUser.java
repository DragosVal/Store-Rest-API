package com.example.store;


import com.example.store.Entity.User;
import com.example.store.Repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class configureUser {

    @Bean
    CommandLineRunner commandLineRunner(UserRepository repository){
        return args -> {
            User user1 = new User("Gogu", "Travis", LocalDate.of(1960, Month.DECEMBER, 13));
            User user2 = new User("Hrusca", "Tradius", LocalDate.of(1970, Month.JANUARY, 15));

            repository.saveAll(List.of(user1,user2));

        };
    }
}
