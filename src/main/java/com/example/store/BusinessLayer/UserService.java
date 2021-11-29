package com.example.store.BusinessLayer;

import com.example.store.Entity.Address;
import com.example.store.Entity.Product;
import com.example.store.Repository.ProductRepository;
import com.example.store.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.store.Entity.User;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository repository;
    private final AddressService addressService;
    private final ProductService productService;

    @Autowired
    UserService(UserRepository repository, AddressService addressService, ProductService productService){

        this.repository = repository;
        this.addressService = addressService;
        this.productService = productService;

    }

    public List<User> getAllUsers(){
        return this.repository.findAll();
    }

    public User getSpecificUser(long id){
        if(!repository.existsById(id))
            throw new IllegalStateException("USER DOES NOT EXIST!!");

        Optional<User> user = this.repository.findById(id);
        return user.get();
    }

    public void addNewUser(User user){
        Optional<User> optionalUser = repository.findByFirstNameAndLastNameAndDateOfBirth(user.getFirstName(), user.getLastName(),user.getDateOfBirth());
        if(optionalUser.isPresent())
            throw new IllegalStateException("This User already exists!!!");

        repository.save(user);
    }

    public void replaceUser(Long id, User user){
        Optional<User> optionalUser = repository.findByFirstNameAndLastNameAndDateOfBirth(user.getFirstName(), user.getLastName(),user.getDateOfBirth());
        if(optionalUser.isPresent())
            throw new IllegalStateException("User credentials are the same!");

        user.setId(id);
        repository.save(user);
    }

    public void deleteUser(Long id) {
        User user = getSpecificUser(id);
        repository.delete(user);
    }

    public void addNewAddress(Long id, Address address) {
        User user = getSpecificUser(id);

        if(!(user.getAddress() == null))
            throw new IllegalStateException("The address exists already...");

        addressService.addNewAddress(address);
        user.setAddress(address);
        repository.save(user);

    }


    public void replaceAddress(Long id, Address address) {

        User user = getSpecificUser(id);
        Address address1 = user.getAddress();

        if(address1 == null){
            addNewAddress(id, address);
        }else{
            if(address.equals(address1))
                throw new IllegalStateException("CANT REPLACE ADDRESS WITH NO CHANGES!!");

            address1.setCity(address.getCity());
            address1.setNumberOfStreet(address.getNumberOfStreet());
            address1.setStreet(address.getStreet());
            repository.save(user);
        }
    }

    public List<Product> getProductsFor(Long id) {
        User user = getSpecificUser( id );
        return user.getProductList();
    }

    public void addProductTo(Long id, Product product) {
        User user = getSpecificUser(id);
        user.addToProductList(product);
        repository.save(user);
    }
}


