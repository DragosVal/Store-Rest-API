package com.example.store;


import com.example.store.Entity.Address;
import com.example.store.Entity.Product;
import com.example.store.Entity.User;
import com.example.store.Repository.AddressRepository;
import com.example.store.Repository.ProductRepository;
import com.example.store.Repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class configureUser {

    @Bean
    CommandLineRunner commandLineRunner(UserRepository repository, AddressRepository addressRepository, ProductRepository productRepository){
        return args -> {

            Product product1 = new Product("Bread", 1,2.31);
            Product product2 = new Product("Eggs", 8,1.2);

            Product product5 = new Product("Pot", 3,18);
            Product product6 = new Product("Hammer", 1,6.40);

            Address address1 = new Address("Timisoara",35,"Nicovala");
            Address address2 = new Address("Hunde", 22,"Secure");

            addressRepository.saveAll(List.of(address1,address2));

            User user1 = new User("Gogu", "Travis", "gogu.star@email.com", LocalDate.of(1960, Month.DECEMBER, 13), address1);
            user1.addToProductList(product1);
            user1.addToProductList(product2);

            User user2 = new User("Hrusca", "Tradius", "tradius.max@email.com", LocalDate.of(1970, Month.JANUARY, 15), address2);
            user2.addToProductList(product6);
            user2.addToProductList(product5);

            repository.saveAll(List.of(user1,user2));


        };
    }


}
