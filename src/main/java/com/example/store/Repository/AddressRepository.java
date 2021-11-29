package com.example.store.Repository;

import com.example.store.Entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long>{

    Optional<Address> findByCityAndNumberOfStreetAndStreet(String city, int numberOfStreet, String street);

}
