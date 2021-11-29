package com.example.store.ApiLayer;

import com.example.store.BusinessLayer.UserService;
import com.example.store.Entity.Address;
import com.example.store.Entity.Product;
import com.example.store.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/UserApi")
public class UserController {

    private final UserService service;

    @Autowired
    UserController(UserService service){
        this.service = service;
    }

    @GetMapping("/allUsers")
    public List<User> getAllUsers(){
        return service.getAllUsers();
    }

    @GetMapping("/selectUser/{id}")
    public User getSpecificUser(@PathVariable Long id){ return service.getSpecificUser(id); }

    @PostMapping("/addNewUser")
    public void registerNewUser(@RequestBody User user){ service.addNewUser(user); }

    @PutMapping("/updateUser/{id}")
    public void replaceUser(@PathVariable Long id, @RequestBody User user){ service.replaceUser(id, user); }

    @DeleteMapping("/deleteUser/{id}")
    public void deleteUser(@PathVariable Long id) { service.deleteUser(id); }

    @PutMapping("/addNewAddressTo/{id}")
    public void addAddress(@PathVariable Long id, @RequestBody Address address){ service.addNewAddress(id, address); }

    @PutMapping("/replaceAddressFor/{id}")
    public void replaceAddress(@PathVariable Long id, @RequestBody Address address){ service.replaceAddress(id, address);}

    @GetMapping("/getProductsFor/{id}")
    public List<Product> getProductsFor(@PathVariable Long id){ return service.getProductsFor(id); }

    @PostMapping("/addProductTo/{id}")
    public void addProductTo(@PathVariable Long id, @RequestBody Product product){ service.addProductTo(id, product); }

}
